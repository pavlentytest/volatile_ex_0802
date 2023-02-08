public class Main {


    /*
    Сделать банковское приложение.
    1 поток - пополняем
    2 поток - снимаем
    Если происходит overdraft - вывести сообщение об этом
    
     */



    public volatile static boolean flag; // false

    public static void main(String[] args) {
        // некое игровое приложение
        // 1-й -поток UI
        // 2-ой поток logic
        new Main().doStart();
    }

    void doStart() {
        new Thread(gui).start();
        System.out.println("Start GUI!");
        new Thread(logic).start();
        System.out.println("Start Logic!");
    }

    Runnable gui = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Stop GUI!");
            flag = true;
        }
    };

    Runnable logic = new Runnable() {
        @Override
        public void run() {
            while(!flag) {
                // беск цикл.
            }
            System.out.println("Stop Logic!");
        }
    };

}