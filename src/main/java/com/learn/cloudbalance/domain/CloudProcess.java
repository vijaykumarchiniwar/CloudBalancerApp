package com.learn.cloudbalance.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@PlanningEntity
public class CloudProcess {
    private int id;
    private int requiredCpuPower;
    private int requiredMemory;
    private int requiredNetworkBandwidth;
    private CloudComputer computer;

    public CloudProcess(int id , int requiredCpuPower, int requiredMemory, int requiredNetworkBandwidth){
        this.id = id;
        this.requiredCpuPower = requiredCpuPower;
        this.requiredMemory= requiredMemory;
        this.requiredNetworkBandwidth = requiredNetworkBandwidth;
    }

    @PlanningVariable(valueRangeProviderRefs = {"computerRange"})
    public CloudComputer getComputer() {
        return computer;
    }
}