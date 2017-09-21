package com.yy.service.impl;


import com.yy.mapper.AccountBalanceMapper;
import com.yy.model.AccountBalance;
import com.yy.service.StatictisAccountService;
import com.yy.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * Description:
 * <p>
 * Created by yaoliang on 2017/9/18 at 下午4:50
 */
@Service
public class StatictisAccountServiceImpl implements StatictisAccountService {

    private final Logger logger = LoggerFactory.getLogger(StatictisAccountServiceImpl.class);

    @Resource
    private AccountBalanceMapper accountBalanceMapper;


    @Override
    public Map<String, List<Double>> statictisAccountData(String site, String account) {

        // 模拟从数据库取出的数据
        List<AccountBalance> abs = initData(site, account);

        // 获取最新的数据
        //List<AccountBalance> abs = accountBalanceMapper.queryByAccountAddrAndSite(site, account);

        if (CollectionUtils.isEmpty(abs)) {
            return Collections.EMPTY_MAP;
        }
        // 组装数据，返回结果
        Map<String, List<Double>> resultMap = new HashMap<>();

        // 库中最新记录的创建时间
        long lastTime = abs.get(0).getCreatedDate();
        // 最新时间
        packageData(resultMap, abs);

        // 前1天时间
        long before1DayTime = DateUtil.getSpecifiedDateByDayAndSource(lastTime, -1);
        // 模拟从数据库取出的数据
        List<AccountBalance> before1Abs = initBefore1BayData(site, account);

        //List<AccountBalance> before1Abs = accountBalanceMapper.queryByAccountAddrAndSiteAndDate(site, account, before1DayTime);
        packageData(resultMap, before1Abs);

//        // 前7天时间
//        long before7DayTime = DateUtil.getSpecifiedDateByDayAndSource(lastTime, -7);
//        List<AccountBalance> before7Abs = accountBalanceMapper.queryByAccountAddrAndSiteAndDate(site, account, before7DayTime);
//        packageData(resultMap, before7Abs);


        return resultMap;
    }

    public Map<String, List<Double>> organizeData(Map<String, List<Double>> map) {
        if (CollectionUtils.isEmpty(map)) return Collections.EMPTY_MAP;
        Map<String, List<Double>> resultMap = new HashMap<>();
        map.forEach((k, v) -> {
            if (v.size() > 0) {
                List<Double> balances = new ArrayList<>();
                Double lastBalance = v.get(0);
                balances.add(lastBalance);
                for (int i = 1; i < v.size(); i++) {
                    Double XBalance = v.get(i);
                    balances.add(XBalance);
                    balances.add(lastBalance - XBalance);
                    balances.add(XBalance == 0.0 ? 0 : (lastBalance - XBalance) / XBalance);
                }
                resultMap.put(k, balances);
            }

        });

        resultMap.forEach((k, v) -> {
            System.out.println("key:" + k);
            System.out.print("value:");
            v.forEach(value -> System.out.print(" " + value));
            System.out.println();
        });

        return resultMap;
    }

    @Override
    public List<String> querySites() {
        return accountBalanceMapper.querySites();
    }

    @Override
    public List<String> queryAccounts() {
        return accountBalanceMapper.queryAccounts();
    }

    public void packageData(Map<String, List<Double>> resultMap, List<AccountBalance> abs) {
        abs.forEach(ab -> {
            String coinName = ab.getCoinName();
            List<Double> balances = resultMap.get(coinName);
            if (CollectionUtils.isEmpty(balances)) {
                balances = new ArrayList<>();
            }
            balances.add(ab.getBalance() + ab.getBalanceFreeze());
            resultMap.put(coinName, balances);
        });
    }

    private List<AccountBalance> initData(String site, String account) {

        List<AccountBalance> accountBalances = new ArrayList<>();

        accountBalances.add(new AccountBalance("wo.com","aa@qq.com","A",0.0556d,0.0030d,1505896832792l,1505896832792l));
        accountBalances.add(new AccountBalance("wo.com","aa@qq.com","B",2.9686d,0.5400d,1505896832792l,1505896832792l));
        accountBalances.add(new AccountBalance("wo.com","aa@qq.com","C",0d,0d,1505896832792l,1505896832792l));
        accountBalances.add(new AccountBalance("wo.com","aa@qq.com","D",0d,0d,1505896832792l,1505896832792l));
        accountBalances.add(new AccountBalance("wo.com","aa@qq.com","E",1229.0075d,0.0002d,1505896832792l,1505896832792l));

        accountBalances.add(new AccountBalance("you.com","aa@qq.com","A",0.0444d,0.0121d,1505896832792l,1505896832792l));
        accountBalances.add(new AccountBalance("you.com","aa@qq.com","B",3.5911d,0d,1505896832792l,1505896832792l));
        accountBalances.add(new AccountBalance("you.com","aa@qq.com","C",0d,0d,1505896832792l,1505896832792l));
        accountBalances.add(new AccountBalance("you.com","aa@qq.com","D",0d,0d,1505896832792l,1505896832792l));
        accountBalances.add(new AccountBalance("you.com","aa@qq.com","E",0d,0d,1505896832792l,1505896832792l));

        return accountBalances;
    }

    private List<AccountBalance> initBefore1BayData(String site, String account) {

        List<AccountBalance> accountBalances = new ArrayList<>();

        accountBalances.add(new AccountBalance("wo.com","aa@qq.com","A",0.0460d,0.0072d,1505810432792l,1505810432792l));
        accountBalances.add(new AccountBalance("wo.com","aa@qq.com","B",3.1383d,0.5900d,1505810432792l,1505810432792l));
        accountBalances.add(new AccountBalance("wo.com","aa@qq.com","C",0d,0d,1505810432792l,1505810432792l));
        accountBalances.add(new AccountBalance("wo.com","aa@qq.com","D",0d,0d,1505810432792l,1505810432792l));
        accountBalances.add(new AccountBalance("wo.com","aa@qq.com","E",1229.0075d,0.0002d,1505810432792l,1505810432792l));

        accountBalances.add(new AccountBalance("you.com","aa@qq.com","A",0.0454d,0.0111d,1505810432792l,1505810432792l));
        accountBalances.add(new AccountBalance("you.com","aa@qq.com","B",3.4401d,0d,1505810432792l,1505810432792l));
        accountBalances.add(new AccountBalance("you.com","aa@qq.com","C",0d,0d,1505810432792l,1505810432792l));
        accountBalances.add(new AccountBalance("you.com","aa@qq.com","D",0d,0d,1505810432792l,1505810432792l));
        accountBalances.add(new AccountBalance("you.com","aa@qq.com","E",1456.0080d,1000d,1505810432792l,1505810432792l));

        return accountBalances;
    }

}
