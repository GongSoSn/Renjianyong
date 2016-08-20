/**
 *
 */
package com.test.cn;

import org.junit.Test;

import com.lecheng.abgame.dao.DAO;

/**
 * @author renjianyong
 *
 */
public class TestDemo {

    @Test
    public void test01() {
        String sql =
                "insert into game(g_name,g_count,g_countscore,g_countavg,g_gno,g_index) select s.pname g_name,s.count g_count,s.sumscore g_countscore,s.s_avg g_countavg,g_no g_gno,t_index g_index from t_grade g,(select name pname,count(s_id) count,sum(s_score) sumscore,AVG(s_score) s_avg from t_player p,t_score s where id = s_id group by s_id) as s where s.s_avg between l_value and h_value;";
        DAO dao = new DAO();
        int a = dao.update(sql, null);
        System.out.println(a);

    }

    @Test
    public void test02() {
        String sql = "truncate table t_player";
        DAO dao = new DAO();
        boolean b = dao.truncateData(sql);
        System.out.println(b);

    }
}
