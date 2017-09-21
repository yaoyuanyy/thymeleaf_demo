package com.yy.service;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/9/18 at 下午8:50
 */
public interface StatictisAccountService {

    /**
     * 根据站点和账户获取账户各时间维度的各币种的统计数量
     * @param site
     * @param account
     * @return
     */
    Map<String, List<Double>> statictisAccountData(String site, String account);

    List<String> querySites();

    List<String> queryAccounts();

}
