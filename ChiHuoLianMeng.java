import java.util.*;
public class ChiHuoLianMeng {
	public static void main(String[] args) {
		//�������壺����
		String[]name=new String[4];
		String[]dismas=new String[4];
		int[]time=new int[4];
		int[] praise = new int[4];
		String[]address= new String[4];
		int[]state=new int [4];//����״̬ 
		double[]sumprice=new double[4];//�ܽ��
		name[0]="����";
		dismas[0]="���մ���";
		time[0]=12;
		address[0]="����";
		state[0]=0;
		sumprice[0]=38.0;
		name[1]="����";
		dismas[1]="��2��";
		time[1]=12;
		address[1]="����";
		state[1]=1;
		sumprice[1]=38.0;
		//��������
		String[]disname={"���մ���","������˿","ʱ���߲�"};
		double[]price={38.0,18.0,10.0};
		int[]praisenum=new int[3];
		//ѭ����while dowhile for)
		//ѭ���Ĳ�����
		//��ʾ���˵�����ʾ�����Ų�ִ�й��� ��ʾ����0���� 
		//ѭ������������0
		
		
		int num=-1;
		do{
			
			//ѭ����while dowhile for)
			//��ʾ���˵�
			System.out.println("**************************");
			System.out.println("1.��Ҫ����");
			System.out.println("2.�鿴�ʹ�");
			System.out.println("3.ǩ�ն���");
			System.out.println("4.ɾ������");
			System.out.println("5.��Ҫ����");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("**************************");
			
			//ѭ���Ĳ�����
			//��ʾ���˵�����ʾ�����Ų�ִ�й��� ��ʾ����0���� 
			//ѭ������������0
			System.out.println("��ѡ��");
			Scanner input=new Scanner(System.in);
			int choose=input.nextInt();
			boolean isAdd=false;//�ҵ�һ��Ϊ�յ�λ�ã����Բ���true������false
			switch(choose){
			case 1:
				//��Ҫ����
				System.out.println("******��Ҫ����******");
				//���Ҳ����λ��
				for(int i=0;i<name.length;i++){
					//���Ϊ�����¼����
					if(name[i]==null){
						isAdd=true;
						//ִ��ѭ������
						//a.��ʾ���пɹ���Ʒ�Ĳ�Ʒ��Ϣ
						System.out.println("���\t����\t������");
						for(int j=0;j<disname.length;j++){
							String prices=price[j]+"Ԫ";
							String praises=praise[j]+"��";
							System.out.println((j+1)+"\t"+disname[j]+"\t"+prices+"\t"+praises);
							
						}
						//������ѡ��Ʒ�ı�ż�����
						System.out.println("��ѡ�������β�Ʒ�����");
						int choosedish=input.nextInt();
						System.out.println("��ѡ����������");
						int number=input.nextInt();
						String dismeg=disname[choosedish-1]+" "+number+"��";
						//b.�����˵�����
						System.out.println("�����붩���˵�����");
						String names=input.next();
						//c.�����Ͳ�ʱ��
						System.out.println("�������Ͳ�ʱ�䣨10�㵽20�����Ͳͣ�");
						int times=input.nextInt();
						//�������ˣ���������
						while(times<10||times>20){
							System.out.println("�Բ������������Ϣ����������10��20֮�������");
							times=input.nextInt();
						}
						//d.�����Ͳ͵�ַ
						System.out.println("�������Ͳ͵�ַ");
						String addresses=input.next();
						//�Ͳͷ�
						double sumprices=price[choosedish-1]*number;
						//�Ͳͷѣ����ͷѴﵽ50Ԫʱ����6Ԫ�Ͳͷ�
						double delicharge=sumprices>=50?0.0:6.0;
						//��ʾ������Ϣ
						System.out.println("���ͳɹ�");
						System.out.println("��������"+dismeg);
						System.out.println("�Ͳ�ʱ�䣺"+times+"��");
						System.out.println("�ͷ�"+sumprices+"�Ͳͷ�"+delicharge+"Ԫ");
						System.out.println("�ܽ��"+(sumprices+delicharge)+"Ԫ");
						//��������
						name[i]=names;
						dismas[i]=dismeg;
						time[i]=times;
						address[i]=addresses;
						sumprice[i]=sumprices+delicharge;
						break;
					}
				}
				if(!isAdd){
					System.out.println("�Բ�����Ķ�������");
				}
				//���û���ҵ�������ʾ��Ϣ
				break;
			case 2:
				//�鿴�ʹ�
				System.out.println("******�鿴�ʹ�*****");
				System.out.println("���\t������\t������Ʒ��Ϣ\t�Ͳ�ʱ��\t\t�Ͳ͵�ַ\t�ܽ��\t״̬");
				//��������
				for(int i=0;i<name.length;i++){
					if(name[i]!=null){
						String times=time[i]+"��";
						String sumprices=sumprice[i]+"Ԫ";
						String states=state[i]==0?"��Ԥ��":"�����";
						System.out.println((i+1)+"\t"+name[i]+"\t"+dismas[i]+"\t\t"+times+"\t\t"+address[i]+"\t"+sumprices+"\t"+states);
					}
				}
				break;
			case 3:
				//ǩ�ն���
				/*��������������ѭ��������
				1 �ҵ���״̬������ɣ���ǩ����ϣ� �����ٴ�ǩ��
				2 �ҵ���״̬����Ԥ����û����ɶ����� ����ǩ��
				3 û�ҵ� ����ǩ��*/
				
				System.out.println("********ǩ�ն���*******");
				System.out.println("��������Ҫǩ�յĶ������");
				int signorderid=input.nextInt();
				boolean isfind=false;//��¼�Ƿ��ҵ� trun�ҵ�falseû�ҵ�
				for(int i=0;i<name.length;i++){
					if(name[i]!=null&&state[i]==1&&signorderid==i+1){
						System.out.println("��ѡ��Ķ����Ѿ����ǩ�գ�����ǩ��");
						isfind=true;
						break;
					}else if(name[i]!=null&&state[i]==0&&signorderid==i+1){
						state[i]=1;//״̬��Ϊ�����״̬
						System.out.println("����ǩ�ճɹ�");
						isfind=true;
						break;
						
						
					}
				}
				//�����жϣ����û���ҵ�������������ȥû���ҵ�
				if(!isfind){
				System.out.println("�Բ���˶���������");
				};
				
				
				break;
			case 4:
				//ɾ������
				/*1.����Ҫɾ���Ķ������
				2.ѭ��������������
				 a.�ҵ������Ѿ�ǩ�� ִ��ɾ������
				 b �ҵ�δǩ�� ��ʾ��Ϣ
				 δ�ҵ��˶�������ʾ����*/
				
				System.out.println("******ɾ������*******");
				System.out.println("������һ��ɾ������");
				//����һ������������
				int delid=input.nextInt();
				int delindex=-1;//ɾ���������±�
				boolean isdelfind=false;//��¼�Ƿ��ҵ� true�ҵ� falseû���ҵ�
				//ѭ��������������
				for(int i=0;i<name.length;i++){
					if(name[i]!=null&&state[i]==1&&delid==i+1){
					  delindex=i;
					  isdelfind=true;
					  break;
				    }else if(name[i]!=null&&state[i]==0&&delid==i+1){
					  System.out.println("��ѡ��Ķ���δǩ�գ�����ɾ��");
					  isdelfind=true;
					  break;
				    }
				}
				/*ɾ��������ѭ����λ��
				��Ҫɾ����Ԫ�ؿ�ʼ������ߵ�Ԫ��һ����ǰ��һλ�����һ��Ԫ�����*/
				if(!isdelfind){
					System.out.println("�Բ��𣬴˶���������");
					
				}
				//ִ��ɾ������
				if(delindex!=-1){
					for(int i=delindex+1;i<name.length;i++){
						name[i-1]=name[i];
						dismas[i-1]=dismas[i];
						time[i-1]=time[i];
						address[i-1]=address[i];
						state[i-1]=state[i];
					}
					//���һλ���
					name[name.length-1]=null;
					dismas[name.length-1]=null;
					time[name.length-1]=0;
					address[name.length-1]=null;
					state[name.length-1]=0;
					System.out.println("ɾ���ɹ�");
				}
				break;
			case 5:
				//��Ҫ����
				/*��Ҫ����
				1.��ʾ�����޵Ĳ�Ʒ�б�
				2.����Ҫ���޵����
				3.��������1
				4.��ʾ���޳ɹ�*/
				System.out.println("*******��Ҫ����********");
				System.out.println("���\t����\t������");
				for(int j=0;j<disname.length;j++){//������Ʒ��
					String prices=price[j]+"Ԫ";
					String praises=praise[j]+"��";
					System.out.println((j+1)+"\t"+disname[j]+"\t"+prices+"\t"+praises);
				}
				System.out.println("������Ҫ���޵Ĳ�Ʒ���");
				int disid=input.nextInt();
				praisenum[disid-1]++;
				System.out.println("���޳ɹ�");
				System.out.println(disname[disid-1]+" "+praisenum[disid-1]+"��");
				
				break;
			case 6:
				//�Ƴ�ϵͳ
				default:
				break;
				
			}
			//���û�����ı��Ϊ1-5֮�������ʱ���˳�ѭ��������
			//���򽫻���ʾ����0����
			if(choose<1||choose>5){
				break;
			}else
			System.out.println("���ز˵��밴0");
			num=input.nextInt();
			
		}while(num==0);
		System.out.println("ллʹ��");
	}
}

