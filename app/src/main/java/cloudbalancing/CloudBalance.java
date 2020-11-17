package cloudbalancing;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class CloudBalance {
  private List<Computer> computerList;
  private List<Process> processList;
  private HardSoftScore score;

  // Required by OptaPlanner to create a planning clone
  public CloudBalance() {}

  public CloudBalance(List<Computer> computerList, List<Process> processList) {
    this.computerList = computerList;
    this.processList = processList;
  }

  @ValueRangeProvider(id = "computerRange")
  @ProblemFactCollectionProperty
  public List<Computer> getComputerList() {
    return computerList;
  }

  @PlanningEntityCollectionProperty
  public List<Process> getProcessList() {
    return processList;
  }

  @PlanningScore
  public HardSoftScore getScore() {
    return score;
  }

  public void setScore(HardSoftScore score) {
    this.score = score;
  }
}
