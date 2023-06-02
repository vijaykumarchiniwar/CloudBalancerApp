package com.learn.cloudbalance.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CloudComputer {
    private int id;
    private int cpuPower;
    private int memory;
    private int networkBandwidth;
    private int cost;
}