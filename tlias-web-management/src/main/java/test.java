// 方法二：写一个“任务清单”
class PrintNumbersTask implements Runnable {
    public void run() {
        // 任务：从1打印到5
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(100); // 干一下歇一下，不然太快了看不清
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

 class FactoryDemo {
    public static void main(String[] args) {
        // 这是我们的主工厂/主线程
        System.out.println("工厂开工了！主工人开始干活...");

        // 1. 创建一个任务清单
        Runnable task = new PrintNumbersTask();

        // 2. 雇佣一个新工人，并把任务清单交给他
        Thread worker1 = new Thread(task, "工人A");

        // 3. 让工人A开始干活
        worker1.start();

        // 主工人自己也干点活
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + ": 干自己的活 " + i);
        }

        System.out.println("主工人的活干完了。");
    }
}