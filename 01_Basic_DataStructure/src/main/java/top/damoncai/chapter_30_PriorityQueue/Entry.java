package top.damoncai.chapter_30_PriorityQueue;

import lombok.Data;
import lombok.ToString;

/**
 * @author zhishun.cai
 * @date 2025/3/4
 */
@Data
@ToString
public class Entry implements Priority{

    private String name;

    private int priority;

    @Override
    public int getPriority() {
        return priority;
    }

    public Entry(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
}
