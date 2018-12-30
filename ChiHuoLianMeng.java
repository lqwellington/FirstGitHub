import java.util.*;
public class ChiHuoLianMeng {
	public static void main(String[] args) {
		//数据主体：数组
		String[]name=new String[4];
		String[]dismas=new String[4];
		int[]time=new int[4];
		int[] praise = new int[4];
		String[]address= new String[4];
		int[]state=new int [4];//订餐状态 
		double[]sumprice=new double[4];//总金额
		name[0]="刘奇";
		dismas[0]="红烧带鱼";
		time[0]=12;
		address[0]="徐州";
		state[0]=0;
		sumprice[0]=38.0;
		name[1]="刘奇";
		dismas[1]="肉2份";
		time[1]=12;
		address[1]="徐州";
		state[1]=1;
		sumprice[1]=38.0;
		//数据主体
		String[]disname={"红烧带鱼","鱼香肉丝","时令蔬菜"};
		double[]price={38.0,18.0,10.0};
		int[]praisenum=new int[3];
		//循环（while dowhile for)
		//循环的操作：
		//显示主菜单，提示输入编号并执行功能 提示输入0返回 
		//循环条件：输入0
		
		
		int num=-1;
		do{
			
			//循环（while dowhile for)
			//显示主菜单
			System.out.println("**************************");
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("**************************");
			
			//循环的操作：
			//显示主菜单，提示输入编号并执行功能 提示输入0返回 
			//循环条件：输入0
			System.out.println("请选择");
			Scanner input=new Scanner(System.in);
			int choose=input.nextInt();
			boolean isAdd=false;//找到一个为空的位置，可以插入true不可以false
			switch(choose){
			case 1:
				//我要订餐
				System.out.println("******我要订餐******");
				//查找插入的位置
				for(int i=0;i<name.length;i++){
					//如果为空则记录下来
					if(name[i]==null){
						isAdd=true;
						//执行循环操作
						//a.显示所有可供餐品的餐品信息
						System.out.println("序号\t单价\t点赞数");
						for(int j=0;j<disname.length;j++){
							String prices=price[j]+"元";
							String praises=praise[j]+"赞";
							System.out.println((j+1)+"\t"+disname[j]+"\t"+prices+"\t"+praises);
							
						}
						//输入所选餐品的编号及份数
						System.out.println("请选择所订参餐品的序号");
						int choosedish=input.nextInt();
						System.out.println("请选择所订份数");
						int number=input.nextInt();
						String dismeg=disname[choosedish-1]+" "+number+"份";
						//b.订餐人的姓名
						System.out.println("请输入订餐人的姓名");
						String names=input.next();
						//c.输入送餐时间
						System.out.println("请输入送餐时间（10点到20整点送餐）");
						int times=input.nextInt();
						//如果输错了，重新输入
						while(times<10||times>20){
							System.out.println("对不起，您输入的信息有误，请输入10到20之间的数：");
							times=input.nextInt();
						}
						//d.输入送餐地址
						System.out.println("请输入送餐地址");
						String addresses=input.next();
						//送餐费
						double sumprices=price[choosedish-1]*number;
						//送餐费，当餐费达到50元时，免6元送餐费
						double delicharge=sumprices>=50?0.0:6.0;
						//显示订单信息
						System.out.println("订餐成功");
						System.out.println("您订的是"+dismeg);
						System.out.println("送餐时间："+times+"点");
						System.out.println("餐费"+sumprices+"送餐费"+delicharge+"元");
						System.out.println("总金额"+(sumprices+delicharge)+"元");
						//保存数据
						name[i]=names;
						dismas[i]=dismeg;
						time[i]=times;
						address[i]=addresses;
						sumprice[i]=sumprices+delicharge;
						break;
					}
				}
				if(!isAdd){
					System.out.println("对不起，你的订单已满");
				}
				//如果没有找到，则提示信息
				break;
			case 2:
				//查看餐袋
				System.out.println("******查看餐袋*****");
				System.out.println("序号\t订餐人\t所订餐品信息\t送餐时间\t\t送餐地址\t总金额\t状态");
				//遍历数组
				for(int i=0;i<name.length;i++){
					if(name[i]!=null){
						String times=time[i]+"点";
						String sumprices=sumprice[i]+"元";
						String states=state[i]==0?"已预定":"已完成";
						System.out.println((i+1)+"\t"+name[i]+"\t"+dismas[i]+"\t\t"+times+"\t\t"+address[i]+"\t"+sumprices+"\t"+states);
					}
				}
				break;
			case 3:
				//签收订单
				/*查找这条订单（循环遍历）
				1 找到。状态是已完成（已签收完毕） 不能再次签收
				2 找到，状态是已预定（没有完成订单） 可以签收
				3 没找到 不可签收*/
				
				System.out.println("********签收订单*******");
				System.out.println("请输入需要签收的订单序号");
				int signorderid=input.nextInt();
				boolean isfind=false;//记录是否找到 trun找到false没找到
				for(int i=0;i<name.length;i++){
					if(name[i]!=null&&state[i]==1&&signorderid==i+1){
						System.out.println("你选择的订单已经完成签收，不能签收");
						isfind=true;
						break;
					}else if(name[i]!=null&&state[i]==0&&signorderid==i+1){
						state[i]=1;//状态改为已完成状态
						System.out.println("订单签收成功");
						isfind=true;
						break;
						
						
					}
				}
				//条件判断：如果没有找到这条订单，才去没有找到
				if(!isfind){
				System.out.println("对不起此订单不存在");
				};
				
				
				break;
			case 4:
				//删除订单
				/*1.输入要删除的订单序号
				2.循环查找这条订单
				 a.找到订单已经签收 执行删除操作
				 b 找到未签收 提示信息
				 未找到此订单：提示订单*/
				
				System.out.println("******删除订单*******");
				System.out.println("请输入一个删除订单");
				//设置一个变量来接收
				int delid=input.nextInt();
				int delindex=-1;//删除订单的下标
				boolean isdelfind=false;//记录是否找到 true找到 false没有找到
				//循环查找这条订单
				for(int i=0;i<name.length;i++){
					if(name[i]!=null&&state[i]==1&&delid==i+1){
					  delindex=i;
					  isdelfind=true;
					  break;
				    }else if(name[i]!=null&&state[i]==0&&delid==i+1){
					  System.out.println("你选择的订单未签收，不能删除");
					  isdelfind=true;
					  break;
				    }
				}
				/*删除操作（循环移位）
				从要删除的元素开始，将后边的元素一次向前移一位，最后一个元素清空*/
				if(!isdelfind){
					System.out.println("对不起，此订单不存在");
					
				}
				//执行删除操作
				if(delindex!=-1){
					for(int i=delindex+1;i<name.length;i++){
						name[i-1]=name[i];
						dismas[i-1]=dismas[i];
						time[i-1]=time[i];
						address[i-1]=address[i];
						state[i-1]=state[i];
					}
					//最后一位清空
					name[name.length-1]=null;
					dismas[name.length-1]=null;
					time[name.length-1]=0;
					address[name.length-1]=null;
					state[name.length-1]=0;
					System.out.println("删除成功");
				}
				break;
			case 5:
				//我要点赞
				/*我要点赞
				1.显示供点赞的餐品列表
				2.输入要点赞的序号
				3.点赞数加1
				4.显示点赞成功*/
				System.out.println("*******我要点赞********");
				System.out.println("序号\t单价\t点赞数");
				for(int j=0;j<disname.length;j++){//遍历餐品名
					String prices=price[j]+"元";
					String praises=praise[j]+"赞";
					System.out.println((j+1)+"\t"+disname[j]+"\t"+prices+"\t"+praises);
				}
				System.out.println("请输入要点赞的餐品序号");
				int disid=input.nextInt();
				praisenum[disid-1]++;
				System.out.println("点赞成功");
				System.out.println(disname[disid-1]+" "+praisenum[disid-1]+"赞");
				
				break;
			case 6:
				//推出系统
				default:
				break;
				
			}
			//当用户输入的编号为1-5之外的数字时，退出循环，否则
			//否则将会提示输入0返回
			if(choose<1||choose>5){
				break;
			}else
			System.out.println("返回菜单请按0");
			num=input.nextInt();
			
		}while(num==0);
		System.out.println("谢谢使用");
	}
}

