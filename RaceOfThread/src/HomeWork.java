import java.util.ArrayList;

public class HomeWork implements Runnable{
    // Threads receive this information directly from the main memory of the computer as data.
    private volatile  int number;

    // An ArrayList of numbers from 1 to 10000 (10 thousand)
    ArrayList<Integer> fullList = new ArrayList<>();

    //4 separate Threads that find odd and even numbers in ArrayLists
    ArrayList<Integer> first = new ArrayList<>();
    ArrayList<Integer> second = new ArrayList<>();
    ArrayList<Integer> third = new ArrayList<>();
    ArrayList<Integer> fourth = new ArrayList<>();

    // odd ArrayList
    ArrayList<Integer> odd = new ArrayList<>();

    // even ArrayList
    ArrayList<Integer> even = new ArrayList<>();


    @Override
    public void run(){
        System.out.print(Thread.currentThread().getName() +"\t:"+this.getNumber()+ " ");
        // the full  ArrayList is empty let's fill it
        if (this.fullList.size() == 0){
            addFull(this.fullList);
        }
        // the first ArrayList is empty let's fill it
        if (this.first.size() == 0){
            addList(fullList,first,second,third,fourth);
        }
        increaseNumber();
        System.out.println("Tek olan sayılar:");
        System.out.println(this.odd);
        System.out.println("########################################### ");
        System.out.println("Cift olan sayilar:");
        System.out.println(this.even);
    }
    public synchronized void increaseNumber(){
        try {
            Thread.sleep(50);

        }catch (InterruptedException e){
            throw  new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());
        switch (Thread.currentThread().getName()) {
            // thread - 1 running
            case "pool-1-thread-1" -> {
                for (int i = 1; i <= this.first.size(); i++) {
                    if (!this.even.contains(i) && !this.odd.contains(i)) {
                        if (i % 2 == 0) {
                            this.even.add(i);
                            System.out.println("Number added to double list: " + i);
                            break;
                        }
                        this.odd.add(i);
                        System.out.println("Number added to single list: " + i);
                        break;
                    }
                }
            }
            // thread - 2 running
            case "pool-1-thread-2" -> {
                for (int i = 2501; i <= this.second.get(this.second.size() - 1); i++) {
                    if (!this.even.contains(i) && !this.odd.contains(i)) {
                        if (i % 2 == 0) {
                            this.even.add(i);
                            System.out.println("Number added to double list: " + i);
                            break;
                        }
                        this.odd.add(i);
                        System.out.println("Number added to single list: " + i);
                        break;
                    }
                }
            }
            // thread - 3 running
            case "pool-1-thread-3" -> {
                for (int i = 5001; i <= this.third.get(this.third.size() - 1); i++) {
                    if (!this.even.contains(i) && !this.odd.contains(i)) {
                        if (i % 2 == 0) {
                            this.even.add(i);
                            System.out.println("Number added to double list: " + i);
                            break;
                        }
                        this.odd.add(i);
                        System.out.println("Number added to single list: " + i);
                        break;
                    }
                }
            }
            // thread - 4 running
            case "pool-1-thread-4" -> {
                for (int i = 7501; i <= this.fourth.get(this.fourth.size() - 1); i++) {
                    if (!this.even.contains(i) && !this.odd.contains(i)) {
                        if (i % 2 == 0) {
                            this.even.add(i);
                            System.out.println("Number added to double list: " + i);
                            break;
                        }
                        this.odd.add(i);
                        System.out.println("Number added to single list: " + i);
                        break;
                    }
                }
            }
        }
    }
    // to add fullList elements
    public void addFull(ArrayList<Integer> list){
        for (int i = 1; i <= 10000; i++){
            list.add(i);
        }
    }
    // to add four array seperate full list four
    public void addList(ArrayList<Integer> fullList,ArrayList<Integer> firstList,ArrayList<Integer> secondList, ArrayList<Integer> thirdList, ArrayList<Integer> fourthList){
        for (int i = 0; i < fullList.size(); i++){
            if (i <= 2500){
                firstList.add(fullList.get(i));
            }else if (i <= 5000) {
                secondList.add(fullList.get(i));
            } else if (i <= 7500) {
                thirdList.add(fullList.get(i));
            } else {
                fourthList.add(fullList.get(i));
            }
        }
    }
    public void stop(){
        boolean isRun = false;
    }
    public int getNumber(){
        return number;
    }
    public void setNumber(int number){
        this.number = number;
    }
}
