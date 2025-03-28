import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

// 1️⃣ 定义策略接口
interface RouteStrategy {
    void buildRoute(String start, String destination);
}

// 2️⃣ 具体策略：不同出行方式
class CarRouteStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String start, String destination) {
        System.out.println("规划驾车路线：" + start + " → " + destination);
    }
}

class WalkingRouteStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String start, String destination) {
        System.out.println("规划步行路线：" + start + " → " + destination);
    }
}

class PublicTransportStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String start, String destination) {
        System.out.println("规划公共交通路线：" + start + " → " + destination);
    }
}

class BikeRouteStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String start, String destination) {
        System.out.println("规划骑行路线：" + start + " → " + destination);
    }
}

// 3️⃣ 上下文类（Navigator）：存储策略，并执行路线规划
class Navigator {
    private RouteStrategy strategy;

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void buildRoute(String start, String destination) {
        if (strategy == null) {
            System.out.println("请选择有效的路线方式！");
        } else {
            strategy.buildRoute(start, destination);
        }
    }
}

// 4️⃣ 用户输入选择出行方式
public class TravelPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Navigator navigator = new Navigator();

        // 方式映射（方便扩展）
        Map<Integer, RouteStrategy> strategyMap = new HashMap<>();
        strategyMap.put(1, new WalkingRouteStrategy());
        strategyMap.put(2, new CarRouteStrategy());
        strategyMap.put(3, new PublicTransportStrategy());
        strategyMap.put(4, new BikeRouteStrategy());

        System.out.println("请选择出行方式：");
        System.out.println("1 - 步行 ");
        System.out.println("2 - 驾车 ");
        System.out.println("3 - 公交 ");
        System.out.println("4 - 骑行 ");

        System.out.print("请输入对应的数字：");
        int choice = scanner.nextInt();
        scanner.nextLine(); // 处理换行符

        // 选择策略
        RouteStrategy selectedStrategy = strategyMap.get(choice);
        if (selectedStrategy == null) {
            System.out.println("❌ 输入无效，请重新运行程序！");
            return;
        }

        // 让用户输入起点和终点
        System.out.print("请输入起点：");
        String start = scanner.nextLine();

        System.out.print("请输入目的地：");
        String destination = scanner.nextLine();

        // 设置并执行策略
        navigator.setStrategy(selectedStrategy);
        navigator.buildRoute(start, destination);

        scanner.close();
    }
}
