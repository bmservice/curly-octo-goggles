public class NewAccount {
    private String account;
    private double balance;

    public NewAccount() {
    }

    public NewAccount(String account, double balance) {
        this.account = account;
        this.balance = balance;
    }

    private boolean flag;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getBalance() {
        return balance;
    }
    //取钱
    public synchronized void draw(double drawAmount) {
        try {
            if (!flag) {
                wait();
            }
            else{
                System.out.println(Thread.currentThread().getName()+"取钱"+drawAmount);
                balance-=drawAmount;
                System.out.println("余额为:"+balance);
                flag=false;
                notifyAll();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //存钱
    public synchronized void deposit(double depositAmount){
        try {
            if(flag){
                wait();
            }
            else{
                System.out.println(Thread.currentThread().getName()+"存钱"+depositAmount);
                balance+=depositAmount;
                System.out.println("余额为:"+balance);
                flag=true;
                notifyAll();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public int hashCode() {
        return account.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if (obj!=null&&obj.getClass()==Account.class){
            Account target=(Account) obj;
            return target.getAccountNo().equals(account);
        }
        return false;
    }
}