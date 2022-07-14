package pl.kurs.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class InsultGenerator implements IInsultGenerator{

    private final List<String> insultPhrases;

    public InsultGenerator() {
        this.insultPhrases = List.of(
          "TY CHUJU JEBANY", "TY MESKA CIPO", "MATKOJEBCO PIERDOLONY", "TY MONGOLSKI POGANIACZU BYDLA"
        );
    }

    @Override
    public String generateInsult() {
        return insultPhrases.get(ThreadLocalRandom.current().nextInt(insultPhrases.size()));
    }
}
