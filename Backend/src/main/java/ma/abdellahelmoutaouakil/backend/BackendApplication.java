package ma.abdellahelmoutaouakil.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import ma.abdellahelmoutaouakil.backend.entities.*;
import ma.abdellahelmoutaouakil.backend.enums.*;
import ma.abdellahelmoutaouakil.backend.repositories.*;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ClientRepository clientRepo,
                            CreditRepository creditRepo,
                            CreditPersonnelRepository creditPersonnelRepo,
                            CreditImmobilierRepository creditImmobilierRepo,
                            CreditProfessionnelRepository creditProfessionnelRepo,
                            RemboursementRepository remboursementRepo) {
        return args -> {
            Client client1 = clientRepo.save(Client.builder().nom("EL QADI").email("qadi@mail.com").build());
            Client client2 = clientRepo.save(Client.builder().nom("EL MOUTAOUAKIL").email("motaa@mail.com").build());

            CreditPersonnel cp = CreditPersonnel.builder()
                    .dateDemande(new Date())
                    .statut(StatutCredit.EN_COURS)
                    .montant(10000)
                    .dureeRemboursement(24)
                    .tauxInteret(3.5)
                    .motif("Achat voiture")
                    .client(client1)
                    .build();
            creditPersonnelRepo.save(cp);

            CreditImmobilier ci = CreditImmobilier.builder()
                    .dateDemande(new Date())
                    .statut(StatutCredit.ACCEPTE)
                    .montant(200000)
                    .dureeRemboursement(240)
                    .tauxInteret(2.1)
                    .typeBien(TypeBien.APPARTEMENT)
                    .client(client2)
                    .build();
            creditImmobilierRepo.save(ci);

            CreditProfessionnel cpro = CreditProfessionnel.builder()
                    .dateDemande(new Date())
                    .statut(StatutCredit.REJETE)
                    .montant(50000)
                    .dureeRemboursement(60)
                    .tauxInteret(4.0)
                    .motif("Investissement matériel")
                    .raisonSociale("SARL EL MOUTAOUAKIL")
                    .client(client1)
                    .build();
            creditProfessionnelRepo.save(cpro);

            remboursementRepo.save(Remboursement.builder()
                    .date(new Date())
                    .montant(500)
                    .type(TypeRemboursement.MENSUALITE)
                    .credit(cp)
                    .build());
            remboursementRepo.save(Remboursement.builder()
                    .date(new Date())
                    .montant(1000)
                    .type(TypeRemboursement.REMBOURSEMENT_ANTICIPE)
                    .credit(ci)
                    .build());
        };
    }
}
