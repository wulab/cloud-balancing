package cloudbalancing;

import java.util.ArrayList;
import java.util.List;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

public class App {
  public static void main(String[] args) {
    // Build the Solver
    SolverFactory<CloudBalance> solverFactory = SolverFactory.createFromXmlResource("cloudbalancing/solverConfig.xml");
    Solver<CloudBalance> solver = solverFactory.buildSolver();

    // Load a problem
    // https://docs.optaplanner.org/7.45.0.Final/optaplanner-docs/html_single/QuickStart/PlainJava/CloudBalancingTutorial/cloudBalanceUseCase.png
    List<Computer> computerList = new ArrayList<Computer>();
    computerList.add(new Computer("X", 7, 6, 13));
    computerList.add(new Computer("Y", 6, 6, 12));

    List<Process> processList = new ArrayList<Process>();
    processList.add(new Process("A", 5, 5));
    processList.add(new Process("B", 4, 3));
    processList.add(new Process("C", 2, 3));
    processList.add(new Process("D", 2, 1));

    CloudBalance unsolvedCloudBalance = new CloudBalance(computerList, processList);

    // Solve the problem
    CloudBalance solvedCloudBalance = solver.solve(unsolvedCloudBalance);

    // Display the result
    StringBuilder solution = new StringBuilder();
    HardSoftScore score = solvedCloudBalance.getScore();

    for (Process process : solvedCloudBalance.getProcessList()) {
      Computer computer = process.getComputer();

      if (computer == null) {
        continue;
      }

      solution.append("* Process " + process.getName() + " -> Computer " + computer.getName() + "\n");
    }

    System.out.println("Solved cloudBalance with " + computerList.size() + " computers and " + processList.size() + " processes:\n");
    System.out.println(solution.toString());
    System.out.println("Score: " + score.toString());
  }
}
