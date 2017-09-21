package com.yy.mapper;

import com.yy.model.AccountBalance;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Description: 账户余额curd等操作
 * <p>
 * Created by oker on 2017/9/12 at 下午6:51
 */
@Mapper
public interface AccountBalanceMapper {

    @Insert("INSERT into account_balance(site, account_addr, coin_name, balance, balance_freeze, created_date, modify_date) " +
            "VALUES(#{site},#{accountAddr},#{coinName},#{balance},#{balanceFreeze},#{createdDate},#{modifyDate})")
    //@Options(useGeneratedKeys=true,keyColumn="mb_id",keyProperty="id")
    void save(AccountBalance ab);


    /**
     * 批量保存
     * @param accountBalances
     */
    @Insert({
            "<script>",
            "insert into account_balance(site, account_addr, coin_name, balance, balance_freeze, created_date, modify_date)",
            "values ",
            "<foreach  collection='accountBalances' item='ab' separator=','>",
            "(#{ab.site},#{ab.accountAddr},#{ab.coinName},#{ab.balance},#{ab.balanceFreeze},#{ab.createdDate},#{ab.modifyDate})",
            "</foreach>",
            "</script>"
    })
    void batchSave(@Param("accountBalances") List<AccountBalance> accountBalances);

    AccountBalance queryById(@Param("id") long id);

    List<AccountBalance> queryByAccountAddr(@Param("accountAddr") String accountAddr);

    List<AccountBalance> queryByCoin(@Param("CoinName") String CoinName);

    /**
     * 获取最新时间的数据
     * @param site
     * @param account
     * @return
     */
    @Select("SELECT " +
            "id, coin_name coinName, site, account_addr accountAddr, balance, balance_freeze balanceFreeze, created_date createdDate " +
            "FROM " +
            "account_balance " +
            "WHERE " +
            "site = #{site} " +
            "AND account_addr = #{account} " +
            "AND created_date=(SELECT created_date from account_balance ORDER BY created_date DESC LIMIT 1)")
    List<AccountBalance> queryByAccountAddrAndSite(@Param("site") String site, @Param("account") String account);


    @Select("SELECT " +
            "id, coin_name coinName, site, account_addr accountAddr, balance, balance_freeze balanceFreeze, created_date createdDate " +
            "FROM " +
            "account_balance " +
            "WHERE " +
            "site = #{site} " +
            "AND account_addr = #{account} " +
            "AND created_date=(SELECT created_date from account_balance WHERE created_date<=#{date} ORDER BY created_date DESC LIMIT 1)")
    List<AccountBalance> queryByAccountAddrAndSiteAndDate(@Param("site") String site, @Param("account") String account, @Param("date") long date);

    @Select("SELECT site from account_balance GROUP BY site")
    List<String> querySites();

    @Select("SELECT account_addr from account_balance GROUP BY account_addr")
    List<String> queryAccounts();


}