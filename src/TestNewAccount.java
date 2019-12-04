public class TestNewAccount {
    public static void main(String[] args) {
        NewAccount n=new NewAccount("12345",0);
        new DrawThread2("取钱人",n,800).start();
        new DepositThread("存钱人1",n,1000).start();
        new DepositThread("存钱人2",n,1000).start();
        new DepositThread("存钱人3",n,1000).start();

    }
}
class DrawThread2 extends Thread{
    private NewAccount account;
    private double drawAmount;

    public DrawThread2(String name,NewAccount account,double drawAmount){
        super(name);
        this.account=account;
        this.drawAmount=drawAmount;
    }
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            account.draw(drawAmount);
        }
    }
}
class DepositThread extends Thread{
    private NewAccount account;
    private double drawAmount;

    public DepositThread(String name,NewAccount account,double drawAmount){
        super(name);
        this.account=account;
        this.drawAmount=drawAmount;
    }
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            account.deposit(drawAmount);
        }
    }
}