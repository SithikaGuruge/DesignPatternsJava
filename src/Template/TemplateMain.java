package Template;

abstract class GameAi{
    boolean ans;
    public void takeTurn(){
        collectResources();
        buildStructure();
        buildUnits();
        if(validate(this.ans))
            action();

    }
    public void collectResources(){
        System.out.println("Resources are collected");
    }
    void sendScouts(int scouts){
        System.out.println("Send scouts: "+ scouts);
    }
    public abstract void action();
    abstract void buildStructure();
    abstract void buildUnits();
    public boolean validate(boolean ans){
        return true;
    }


}

class OrcsAI extends GameAi{
    public OrcsAI(boolean ans){
        this.ans = ans;
    }

    @Override
    void buildStructure() {
        System.out.println("build Structure of OrcsAI");
    }

    @Override
    void buildUnits() {
        System.out.println("build units of OrcsAI");
    }

    @Override
    public void action(){
        sendScouts(30);
    }
    public boolean validate(boolean ans){
        return ans;
    }
}

class MonsterAi extends GameAi{
    public MonsterAi(boolean ans){

        this.ans = ans;
        }

    @Override
    void buildStructure() {
        System.out.println("build structure of MonsterAi");
    }

    @Override
    void buildUnits() {
        System.out.println("build units of MonsterAi");
    }

    @Override
    public void action(){
            sendScouts(20);
    }
    public boolean validate(boolean ans){
        return ans;
    }
}

public class TemplateMain {
    public static void main(String[] args) {
       OrcsAI orcsAI = new OrcsAI(true);
        MonsterAi monsterAi = new MonsterAi(false);
        orcsAI.takeTurn();
        monsterAi.takeTurn();
    }
}
