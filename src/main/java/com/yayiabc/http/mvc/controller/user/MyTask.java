package com.yayiabc.http.mvc.controller.user;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import org.springframework.stereotype.Component;

import com.yayiabc.common.cahce.CacheUtils;
import com.yayiabc.common.utils.BeanUtil;
import com.yayiabc.http.mvc.pojo.jpa.OrderItem;
import com.yayiabc.http.mvc.service.TimerChangeStateService;
@Component
public class MyTask extends TimerTask{
	/*@Autowired*/
	private TimerChangeStateService timerChangeStateService;
	@Override
	public void run() {
		kk();
			}
	private   synchronized void kk(){
		TimerChangeStateService timerChangeStateService=BeanUtil.getBean("TimerChangeStateServiceImpl");
		CacheUtils cache=	CacheUtils.getInstance();
		Map<String,Date> map=cache.getCacheMap();
		for(String key:map.keySet()){
			if(new Date().getTime()-map.get(key).getTime()>=1*60*1000
					){
				//查看该单state  状态 
				//System.err.println();
				System.out.println(key);
				
				int state=timerChangeStateService.timerQueryState(key);
				if(state==1){
					//  更改数据库交易状态为 交易关闭
					int sign=timerChangeStateService.changeState(key);
					if(sign>0){
						
						//把该订单里的 商品 在返回库存表里去啊啊啊啊啊
					 //根据订单id 查该订单里面的所有商品
						List<OrderItem> orderItemList=timerChangeStateService.queryOrderItems(key);
						for(int i=0;i<orderItemList.size();i++){
							//还给库存表orderItemList.get(i).getItemSKU()
							timerChangeStateService.stillItemValueNum(orderItemList.get(i).getItemSKU(),
									orderItemList.get(i).getNum()
									);
							
						}
						map.remove(key);
					}
				}
                 
			}
			if(map.get(key)!=null){
				if(new Date().getTime()-map.get(key).getTime()>=cache.getContinuedTime()){
					map.remove(key);
				}
			}
		}

	}
}
