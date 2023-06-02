package com.learn.cloudbalance;

import com.learn.cloudbalance.domain.CloudComputer;
import com.learn.cloudbalance.domain.CloudProcess;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

@Setter
@NoArgsConstructor
@PlanningSolution
public class CloudBalance {
    private List<CloudComputer> computerList;
    private List<CloudProcess> processList;
    private HardSoftScore score;

    @ValueRangeProvider(id = "computerRange")
    @ProblemFactCollectionProperty
    public List<CloudComputer> getComputerList() {
        return computerList;
    }

    @PlanningEntityCollectionProperty
    public List<CloudProcess> getProcessList() {
        return processList;
    }

    @PlanningScore
    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "CloudBalance{" +
                //"computerList=" + computerList +
                ", processList=" + processList.toString() +
                ", score=" + score +
                '}';
    }
}
