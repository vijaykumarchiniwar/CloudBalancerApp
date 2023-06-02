package com.learn.cloudbalance;

import com.learn.cloudbalance.domain.CloudComputer;
import com.learn.cloudbalance.domain.CloudProcess;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import java.util.ArrayList;
import java.util.List;

public class CloudbalanceApp {
    public static void main(String[] args) {
        // Build the Solver
        SolverFactory<CloudBalance> solverFactory = SolverFactory
                .createFromXmlResource("cloudBalancingSolverConfig.xml");
        Solver<CloudBalance> solver = solverFactory.buildSolver();
        // Load a problem with 400 computers and 1200 processes
        CloudBalance unsolvedCloudBalance = generateProblem();

        // Solve the problem
        CloudBalance solvedCloudBalance = solver.solve(unsolvedCloudBalance);

        // Display the result
        System.out.println(String.format("\nSolved cloudBalance with %s computers and %s processes with sol : %s \n",
                solvedCloudBalance.getComputerList().size(), solvedCloudBalance.getProcessList().size(), solvedCloudBalance.toString()));
    }

    private static CloudBalance generateProblem() {
        CloudBalance cloudBalance= new  CloudBalance();

        List<CloudComputer> computerList = new ArrayList<>();
        computerList.add(new CloudComputer(1,2, 200, 60, 10));
        computerList.add(new CloudComputer(2, 1, 600, 40, 4));
        computerList.add(new CloudComputer(3, 3, 400, 50, 14));

        List<CloudProcess> processList = new ArrayList<>();
        processList.add(new CloudProcess(1, 1, 300, 4));
        processList.add(new CloudProcess(2, 2, 300, 4));
        processList.add(new CloudProcess(3, 1, 200, 4));
        processList.add(new CloudProcess(4, 1, 100, 4));

        cloudBalance.setComputerList(computerList);
        cloudBalance.setProcessList(processList);
        return cloudBalance;
    }
}
