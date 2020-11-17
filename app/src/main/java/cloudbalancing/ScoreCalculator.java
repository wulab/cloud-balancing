package cloudbalancing;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.calculator.EasyScoreCalculator;

public class ScoreCalculator implements EasyScoreCalculator<CloudBalance, HardSoftScore> {
  public HardSoftScore calculateScore(CloudBalance cloudBalance) {
    int hardScore = 0;
    int softScore = 0;

    for (Computer computer : cloudBalance.getComputerList()) {
      int cpuPowerUsage = 0;
      int memoryUsage = 0;
      boolean used = false;

      for (Process process : cloudBalance.getProcessList()) {
        if (computer.equals(process.getComputer())) {
          cpuPowerUsage += process.getRequiredCpuPower();
          memoryUsage += process.getRequiredMemory();
          used = true;
        }
      }

      // Hard constraints
      int cpuPowerAvailable = computer.getCpuPower() - cpuPowerUsage;
      int memoryAvailable = computer.getMemory() - memoryUsage;

      if (cpuPowerAvailable < 0) {
        hardScore += cpuPowerAvailable;
      }

      if (memoryAvailable < 0) {
        hardScore += memoryAvailable;
      }

      // Soft constraints
      if (used) {
        softScore -= computer.getCost();
      }
    }

    return HardSoftScore.valueOf(hardScore, softScore);
  }
}
