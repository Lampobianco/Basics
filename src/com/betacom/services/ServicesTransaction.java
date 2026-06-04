package com.betacom.services;

import java.time.LocalDate;

import com.betacom.dao.ClientiDao;
import com.betacom.dao.DipendentiDao;
import com.betacom.dao.RapportoClienteDao;
import com.betacom.objects.Cliente;
import com.betacom.objects.Dipendenti;
import com.betacom.objects.RapportoCliente;
import com.betacom.singleton.SQLConfiguration;
import com.betacom.utils.GestioneSQL;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ServicesTransaction {

	private final DipendentiDao daoD;
	private final ClientiDao daoC;
	private final RapportoClienteDao daoR;
	private final GestioneSQL db;

	public ServicesTransaction() {
		this.daoD = new DipendentiDao();
		this.daoC = new ClientiDao();
		this.daoR = new RapportoClienteDao();
		this.db = new GestioneSQL();
	}

	public void executeTransaction() throws Exception {
		log.info("Begin executeTransaction ********");
		try {
			SQLConfiguration.getInstance().setTransaction();

			Dipendenti dip = Dipendenti.builder()
					.nome("Alice")
					.cognome("Blueta")
					.dataAssunzione(LocalDate.of(2001, 05, 26))
					.mansioni("impiegato")
					.stipendio(1800.0)
					.idUfficio(4)
					.telefono("2345612")
					.build();
			int idDip = daoD.insert("update.dipendenti.insert", dip);
			log.debug("Dipendente created :{}", idDip);

			Cliente cli = Cliente.builder()
					.denominazione("Transaction SRL")
					.pIva("2143546565")
					.indirizzo("via lattea 12 Sestriere")
					.telefono("98346537")
					.build();
			int idCli = daoC.insert("update.clienti.insert", cli);
			log.debug("Cliente created :{}", idCli);

			RapportoCliente rap = RapportoCliente.builder()
					.descrizione("rapporto transazione")
					.idCliente(idCli)
					.idDipendente(idDip)
					.build();
			int idRap = daoR.insert("update.rapportoCliente.insert", rap);
			log.debug("Rapporto cliente {}", idRap);
			
			log.debug("Numero righe cancellate per Rapporto cliente {}", daoR.delete(idRap));
			log.debug("Numero righe cancellate per Cliente {}", daoC.delete(idCli));
			log.debug("Numero righe cancellate per Dipendente {}", daoD.delete(idDip));
				
			//int i = 0;
			//idDip = idDip/ i;
			// verifica che il rollback sia sempre effettuato
			
			SQLConfiguration.getInstance().commit();
		} catch (Exception e) {
			log.error("error found {}", e.getMessage());
			SQLConfiguration.getInstance().rollback();
		}
	}
	
	
	

}
