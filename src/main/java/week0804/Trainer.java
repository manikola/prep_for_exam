package week0804;

public class Trainer {

    private CanMark canMark;

    public Trainer(CanMark canMark) {
        this.canMark = canMark;
    }

    public CanMark getCanMark() {
        return canMark;
    }

    public int giveMark(){
        return canMark.giveMark();
    }

    public static void main(String[] args) {
        Trainer goodTrainer = new Trainer(new GoodMood());
        Trainer badTrainer = new Trainer(new BadMood());

        System.out.println(goodTrainer.giveMark());
        System.out.println(badTrainer.giveMark());
    }
}
