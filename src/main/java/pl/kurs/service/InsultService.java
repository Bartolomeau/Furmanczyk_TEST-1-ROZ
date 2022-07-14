package pl.kurs.service;

public class InsultService implements IInsultService{

    private IInsultGenerator iInsultGenerator;

    @Override
    public String getInsult(String target) {
        return target + " " + iInsultGenerator.generateInsult();
    }
}
