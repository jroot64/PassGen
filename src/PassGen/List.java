package PassGen;

public class List{
    ReadLine r = new ReadLine();
    public Password[] save, tmp;
    private int length=0;

    protected void save(Password toSave){
        extend();
        save[length]=toSave;
        length ++;
    }
    private void extend(){
        tmp = new Password[length+1];
//        System.arraycopy(save,0,tmp,0,length+1);
        for (int i = 0; i < length; i++) {
            tmp[i] = save[i];
        }
        save = new Password[length+1];
//        System.arraycopy(tmp,0,save,0,length+1);
        for (int i = 0; i < length; i++) {
            save[i] = tmp[i];
        }
    }
    protected Password getsave(int i){
        return save[i];
    }

    protected void delet(List toDelete){
        toDelete.out();
        System.out.println(length);
        System.out.println("Welcher Eintrag soll delöscht werden?");
//        ReadLine read = new ReadLine();
        reduce((Integer.parseInt(r.read())));
        toDelete.out();
    }
    private void reduce(int number){
        tmp = new Password[length-1];
        for (int i = 0; i < length; i++) {
            if (i<number){tmp[i]=save[i];}
//            if (i==number){}
            if (i>number){tmp[i-1]=save[i];}
        }
        save = new Password[length-1];
        for (int i = 0; i < (length - 1); i++) save[i] = tmp[i];
        length = length-1;
    }

    protected void outLength(){
        System.out.println(length);
    }
    protected void out() {
        for (int i = 0; i < length; i++) {
            System.out.println(i + ") " + save[i].getPassForApplication() + "-> " + save[i].getPassPhrese());
        }
    }

}
