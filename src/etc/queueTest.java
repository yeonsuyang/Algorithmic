package etc;/*
 * com.study.yeonsu qt.java 2019. 3. 29.
 *
 * Copyright (c) 2001-2013 Alticast Corp.
 * All rights reserved. http://www.alticast.com/
 *
 * This software is the confidential and proprietary information of
 * Alticast Corp. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Alticast.
 */

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/** 
 * qt Class
 * 클래스가 어떠한 것을 처리하기 위한 클래스인지 명시 한다.
 * (ex:이 클래스는 어떤것을 처리하기 위해 작성된 클래스이다.)
 * <p>
 * 클래스(qt) 사용의 Sample을 명시 한다.
 * <pre>; 
 * qt c = new qt();
 * c.test();
 * <pre>;
 * <p>클래스 사용중 중요 이슈를 명시 한다. 
 * (ex:미완성중인 것이라던가 어떠한 Method는 어떠한 Class는 꼭 어떻게 써야 한다라든가)
 * 
 * <p>Copyright (c) 1997-2013 Alticast, Inc. All rights reserved.
 *
 * @since	1.0
 * @author	ysyang - 2019. 3. 29.
 */
public class queueTest {
	public static void main(String[] args) {
		Queue<Prisoner> q = new LinkedList<Prisoner>();
		PriorityQueue<Prisoner> pq = new PriorityQueue<Prisoner>();
		
		
		q.add(new Prisoner("1",7));
		pq.add(new Prisoner("1",7));
		
		q.add(new Prisoner("2",5));
		pq.add(new Prisoner("2",5));
		
		q.add(new Prisoner("1",5));
		pq.add(new Prisoner("1",5));
		
		q.add(new Prisoner("1",2));
		pq.add(new Prisoner("1",2));
		
		q.add(new Prisoner("1",3));
		pq.add(new Prisoner("1",3));
		
		while (!q.isEmpty()){
				Prisoner p = q.poll();
		        System.out.println("q : " +p.name+","+p.weight);
		}
	
	   while (!pq.isEmpty()){
			Prisoner p2 = pq.poll();
	        System.out.println("pq : " +p2.name+","+p2.weight);
	   }

		
	}

}

class Prisoner implements Comparable<Prisoner> {

    String name;
    int weight; // 형량

    public Prisoner(String name, int weight) {
        //super();
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Prisoner target) {
        if (this.weight > target.weight) {
            return 1;
        } else if (this.weight < target.weight) {
            return -1;
        }
        return 0;
    }
}

