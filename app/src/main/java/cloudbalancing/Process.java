package cloudbalancing;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Process {
  private String name;
  private int requiredCpuPower;
  private int requiredMemory;

  private Computer computer;

  // Required by OptaPlanner to create a planning clone
  public Process() {}

  public Process(String name, int requiredCpuPower, int requiredMemory) {
    this.name = name;
    this.requiredCpuPower = requiredCpuPower;
    this.requiredMemory = requiredMemory;
  }

  @PlanningVariable(valueRangeProviderRefs = {"computerRange"})
  public Computer getComputer() {
    return computer;
  }

  public void setComputer(Computer computer) {
    this.computer = computer;
  }

  public String getName() {
    return name;
  }

  public int getRequiredCpuPower() {
    return requiredCpuPower;
  }

  public int getRequiredMemory() {
    return requiredMemory;
  }
}
