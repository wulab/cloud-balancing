package cloudbalancing;

public class Computer {
  private String name;
  private int cpuPower;
  private int memory;
  private int cost;

  // Required by OptaPlanner to create a planning clone
  public Computer() {}

  public Computer(String name, int cpuPower, int memory, int cost) {
    this.name = name;
    this.cpuPower = cpuPower;
    this.memory = memory;
    this.cost = cost;
  }

  public String getName() {
    return name;
  }

  public int getCpuPower() {
    return cpuPower;
  }

  public int getMemory() {
    return memory;
  }

  public int getCost() {
    return cost;
  }
}
