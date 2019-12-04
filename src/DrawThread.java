public class DrawThread extends Thread{
    //模拟用户账户
    private  Account account;
    private double drawAmount;
    public DrawThread(String name,Account account,double drawAmount) {
        super(name);
        this.account=account;
        this.drawAmount=drawAmount;
    }

    @Override
    public void run() {
        account.draw(drawAmount);
    }
    public static void main(String[] args) {
        Account account=new Account("账户",1000);
        new DrawThread("甲",account,800).start();
        new DrawThread("乙",account,800).start();

    }
}
