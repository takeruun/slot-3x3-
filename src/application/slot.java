package application;


import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;


public class slot extends Application{
	Label lbstatus = new Label("Slot");
	Label lbresult = new Label("");
	Label lbcount = new Label ("");
	Label lblast = new Label ("");
	Button startbt = new Button("start");
	Button[] stopbt = new Button[3];
	Canvas[] cv1 = new Canvas[3];
	Canvas[] cv2 = new Canvas[3];
	Canvas[] cv3 = new Canvas[3];
 	BorderPane bp = new BorderPane();
 	BorderPane bp_point = new BorderPane();
	VBox vb = new VBox();
	HBox Shb1 = new HBox();
	HBox Shb2 = new HBox();
	HBox Shb3 = new HBox();
	HBox hb2 = new HBox();
	HBox hb3 = new HBox();
	GraphicsContext g;
	Timeline timer1 = new Timeline();
	Timeline timer2 = new Timeline();
	Timeline timer3 = new Timeline();
	Image[] img = new Image[17];
	int[] num = new int[9];
	int time1=150, time2=150, time3=150;
	int key=0;
	int[] n = new int[3];
	int[] j = new int[3];
	int count=10;
	int point=0;

	public static void main(String[] args)
	{
		launch(args);
	}

	public void start(Stage stage) throws Exception
	{
		for(int i=0; i<3; i++)
		{
			stopbt[i] = new Button("stop");
			cv1[i] = new Canvas(90, 90);
			cv2[i] = new Canvas(90, 90);
			cv3[i] = new Canvas(90, 90);
		}

		//読み込み
		for(int i=0; i<17; i++)
		{
			String str = String.format("image%d.jpg", i);
			img[i] = new Image(str);
		}

		lbresult.setTextFill(Color.GREEN);
		lbcount.setTextFill(Color.BLUE);
		lbcount.setFont(Font.font("Serif", 20));
		lbcount.setText("残り"+count+"回");
		lblast.setTextFill(Color.RED);
		lblast.setFont(Font.font("Serif", 20));
		//上列
		Shb1.getChildren().addAll(cv1);
		Shb1.setSpacing(20);
		Shb1.setAlignment(Pos.CENTER);
		//中列
		Shb2.getChildren().addAll(cv2);
		Shb2.setSpacing(20);
		Shb2.setAlignment(Pos.CENTER);
		//下列
		Shb3.getChildren().addAll(cv3);
		Shb3.setSpacing(20);
		Shb3.setAlignment(Pos.CENTER);
		//ボタン列
		hb2.getChildren().addAll(stopbt);
		hb2.setSpacing(60);
		hb2.setAlignment(Pos.CENTER);
		//結果表示列
		hb3.getChildren().addAll(lbstatus, lbresult, lblast);
		hb3.setSpacing(20);
		hb3.setAlignment(Pos.CENTER);
		
		vb.getChildren().addAll(startbt,Shb1,Shb2,Shb3,hb2);
		vb.setSpacing(20);
		vb.setAlignment(Pos.CENTER);
		bp.setTop(lbcount);
		
		bp.setCenter(vb);
		bp.setBottom(hb3);
		

		startbt.setOnAction(new StartSlot());
		stopbt[0].setOnAction(new StopSlot1());
		stopbt[1].setOnAction(new StopSlot2());
		stopbt[2].setOnAction(new StopSlot3());
		
		stopbt[0].setDisable(true);
		stopbt[1].setDisable(true);
		stopbt[2].setDisable(true);
		
		Scene sc = new Scene(bp, 400, 500);
		stage.setScene(sc);
		stage.setTitle("スロット！");
		
		Stage stage1 = new Stage();
		Scene sc_point = new Scene(bp_point,400,200);
		stage1.setScene(sc_point);
		stage1.setTitle("得点表");
		
		stage.show();
		stage1.show();
		
		
	}
	
	void RandomSlot1()
	{
		 KeyFrame kf1 =  new KeyFrame(
			   new Duration(time1),
			   new EventHandler<ActionEvent>(){
			        @Override
			        public void handle(ActionEvent e) {
			        	Random rnd = new Random();
			   		    
			   		    for(;;) {
			   		    	num[0] = rnd.nextInt(17);
			   		    	num[3] = rnd.nextInt(17);
			   		    	num[6] = rnd.nextInt(17);	
			   		    	if(num[0]!=num[3]&&num[0]!=num[6]&&num[3]!=num[6]) {
			   		    		break;
			   		    	}
			   		    }
			   		    
			        	g = cv1[0].getGraphicsContext2D();
			    		g.drawImage(img[num[0]], 0, 0);
			    		g = cv2[0].getGraphicsContext2D();
			    		g.drawImage(img[num[3]], 0, 0);
			    		g = cv3[0].getGraphicsContext2D();
			    		g.drawImage(img[num[6]], 0, 0);
			        }
			   }
		    )
		 ;
		 timer1.getKeyFrames().add(kf1);
		 timer1.setCycleCount(Timeline.INDEFINITE);
		 timer1.play();
	}

	void RandomSlot2()
	{
		 KeyFrame kf2 =  new KeyFrame(
				   new Duration(time2),
				   new EventHandler<ActionEvent>(){
				        @Override
				        public void handle(ActionEvent e) {
				        	Random rnd = new Random();
				        	for(;;) {
				   		    	num[1] = rnd.nextInt(17);
				   		    	num[4] = rnd.nextInt(17);
				   		    	num[7] = rnd.nextInt(17);	
				   		    	if(num[1]!=num[4]&&num[1]!=num[7]&&num[4]!=num[7]) {
				   		    		break;
				   		    	}
				   		    }
				        	g = cv1[1].getGraphicsContext2D();
				    		g.drawImage(img[num[1]], 0, 0);		
				    		g = cv2[1].getGraphicsContext2D();
				    		g.drawImage(img[num[4]], 0, 0);	
				    		g = cv3[1].getGraphicsContext2D();
				    		g.drawImage(img[num[7]], 0, 0);	
				        }
				   }
			    )
			 ;
			 timer2.getKeyFrames().add(kf2);
			 timer2.setCycleCount(Timeline.INDEFINITE);
			 timer2.play();
	}
	
	void RandomSlot3()
	{
		 KeyFrame kf3 =  new KeyFrame(
				   new Duration(time3),
				   new EventHandler<ActionEvent>(){
				        @Override
				        public void handle(ActionEvent e) {
				        	Random rnd = new Random();
				        	for(;;) {
				   		    	num[2] = rnd.nextInt(17);
				   		    	num[5] = rnd.nextInt(17);
				   		    	num[8] = rnd.nextInt(17);	
				   		    	if(num[2]!=num[5]&&num[2]!=num[8]&&num[5]!=num[8]) {
				   		    		break;
				   		    	}
				   		    }
				        	g = cv1[2].getGraphicsContext2D();
				    		g.drawImage(img[num[2]], 0, 0);
				        	g = cv2[2].getGraphicsContext2D();
				    		g.drawImage(img[num[5]], 0, 0);
				        	g = cv3[2].getGraphicsContext2D();
				    		g.drawImage(img[num[8]], 0, 0);
				        }
				   }
			    )
			 ;
			 timer3.getKeyFrames().add(kf3);
			 timer3.setCycleCount(Timeline.INDEFINITE);
			 timer3.play();
	}
	
	class StartSlot implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e)
		{
			startbt.setDisable(true);
			stopbt[0].setDisable(false);
			stopbt[1].setDisable(false);
			stopbt[2].setDisable(false);
			RandomSlot1();
			RandomSlot2();
			RandomSlot3();
			count--;
			lbcount.setText("残り"+count+"回");
			lbresult.setText("");
		}
	}
	
	class StopSlot1 implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e)
		{
			timer1.pause();
			stopbt[0].setDisable(true);
			key++;
			
			if(num[0]==0 || num[0]==1 || num[0]==2)
				n[0] = 0;
			else if(num[0]==3 || num[0]==4 || num[0]==5)
				n[0] = 1;
			else if(num[0]==6 || num[0]==7)
				n[0] = 2;
			else if(num[0]==8 || num[0]==9)
				n[0] = 3;
			else if(num[0]==10 || num[0]==11)
				n[0] = 4;
			else if(num[0]==12 || num[0]==13)
				n[0] = 5;
			else if(num[0]==14 || num[0]==15)
				n[0] = 6;
			else {n[0]=7;}
			
			if(num[3]==0 || num[3]==1 || num[3]==2)
				n[1] = 0;
			else if(num[3]==3 || num[3]==4 || num[3]==5)
				n[1] = 1;
			else if(num[3]==6 || num[3]==7)
				n[1] = 2;
			else if(num[3]==8 || num[3]==9)
				n[1] = 3;
			else if(num[3]==10 || num[3]==11)
				n[1] = 4;
			else if(num[3]==12 || num[3]==13)
				n[1] = 5;
			else if(num[3]==14 || num[3]==15)
				n[1] = 6;
			else {n[1]=7;}
			
			if(num[6]==0 || num[6]==1 || num[6]==2)
				n[2] = 0;
			else if(num[6]==3 || num[6]==4 || num[6]==5)
				n[2] = 1;
			else if(num[6]==6 || num[6]==7)
				n[2] = 2;
			else if(num[6]==8 || num[6]==9)
				n[2] = 3;
			else if(num[6]==10 || num[6]==11)
				n[2] = 4;
			else if(num[6]==12 || num[6]==13)
				n[2] = 5;
			else if(num[6]==14 || num[6]==15)
				n[2] = 6;
			else {n[2]=7;}
			
			if(key%3==0)
				judge(n[0], n[1], n[2], 1);
		}
	}
	
	class StopSlot2 implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e)
		{
			timer2.pause();
			stopbt[1].setDisable(true);
			key++;
			
			if(num[1]==0 || num[1]==1 || num[1]==2)
				n[0] = 0;
			else if(num[1]==3 || num[1]==4 || num[1]==5)
				n[0] = 1;
			else if(num[1]==6 || num[1]==7)
				n[0] = 2;
			else if(num[1]==8 || num[1]==9)
				n[0] = 3;
			else if(num[1]==10 || num[1]==11)
				n[0] = 4;
			else if(num[1]==12 || num[1]==13)
				n[0] = 5;
			else if(num[1]==14 || num[1]==15)
				n[0] = 6;
			else {n[0]=7;}
			
			if(num[4]==0 || num[4]==1 || num[4]==2)
				n[1] = 0;
			else if(num[4]==3 || num[4]==4 || num[4]==5)
				n[1] = 1;
			else if(num[4]==6 || num[4]==7)
				n[1] = 2;
			else if(num[4]==8 || num[4]==9)
				n[1] = 3;
			else if(num[4]==10 || num[4]==11)
				n[1] = 4;
			else if(num[4]==12 || num[4]==13)
				n[1] = 5;
			else if(num[4]==14 || num[4]==15)
				n[1] = 6;
			else {n[1]=7;}
			
			if(num[7]==0 || num[7]==1 || num[7]==2)
				n[2] = 0;
			else if(num[7]==3 || num[7]==4 || num[7]==5)
				n[2] = 1;
			else if(num[7]==6 || num[7]==7)
				n[2] = 2;
			else if(num[7]==8 || num[7]==9)
				n[2] = 3;
			else if(num[7]==10 || num[7]==11)
				n[2] = 4;
			else if(num[7]==12 || num[7]==13)
				n[2] = 5;
			else if(num[7]==14 || num[7]==15)
				n[2] = 6;
			else {n[2]=7;}
			
			if(key%3==0)
				judge(n[0], n[1], n[2], 2);
		}
	}

	class StopSlot3 implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e)
		{
			timer3.pause();
			stopbt[2].setDisable(true);
			key++;
			
			if(num[2]==0 || num[2]==1 || num[2]==2)
				n[0] = 0;
			else if(num[2]==3 || num[2]==4 || num[2]==5)
				n[0] = 1;
			else if(num[2]==6 || num[2]==7)
				n[0] = 2;
			else if(num[2]==8 || num[2]==9)
				n[0] = 3;
			else if(num[2]==10 || num[2]==11)
				n[0] = 4;
			else if(num[2]==12 || num[2]==13)
				n[0] = 5;
			else if(num[2]==14 || num[2]==15)
				n[0] = 6;
			else {n[0]=7;}
			
			if(num[5]==0 || num[5]==1 || num[5]==2)
				n[1] = 0;
			else if(num[5]==3 || num[5]==4 || num[5]==5)
				n[1] = 1;
			else if(num[5]==6 || num[5]==7)
				n[1] = 2;
			else if(num[5]==8 || num[5]==9)
				n[1] = 3;
			else if(num[5]==10 || num[5]==11)
				n[1] = 4;
			else if(num[5]==12 || num[5]==13)
				n[1] = 5;
			else if(num[5]==14 || num[5]==15)
				n[1] = 6;
			else {n[1]=7;}
			
			if(num[8]==0 || num[8]==1 || num[8]==2)
				n[2] = 0;
			else if(num[8]==3 || num[8]==4 || num[8]==5)
				n[2] = 1;
			else if(num[8]==6 || num[8]==7)
				n[2] = 2;
			else if(num[8]==8 || num[8]==9)
				n[2] = 3;
			else if(num[8]==10 || num[8]==11)
				n[2] = 4;
			else if(num[8]==12 || num[8]==13)
				n[2] = 5;
			else if(num[8]==14 || num[8]==15)
				n[2] = 6;
			else {n[2]=7;}
			
			if(key%3==0)
				judge(n[0], n[1], n[2], 3);
		}
	}
	
	void judge(int x, int y, int z, int t)
	{
		int[][] judge = new int[3][3];
		if(t==0) {
			judge[0][0]=x;
			judge[1][0]=y;
			judge[2][0]=z;
		}
		else if(t==1) {
			judge[0][1]=x;
			judge[1][1]=y;
			judge[2][1]=z;
			}
		else
		{
			judge[0][2]=x;
			judge[1][2]=y;
			judge[2][2]=z;
		}
		
		if(judge[0][0]==judge[0][1] && judge[0][1]==judge[0][2]) {
			j[0]=judge[0][0];
			j[1]=j[0];
			j[2]=j[0];
		}else if(judge[1][0]==judge[1][1] && judge[1][1]==judge[1][2]) {
			j[0]=judge[1][0];
			j[1]=j[0];
			j[2]=j[0];
		}else if(judge[2][0]==judge[2][1] && judge[2][1]==judge[2][2]) {
			j[0]=judge[2][0];
			j[1]=j[0];
			j[2]=j[0];
		}
		else if(judge[0][0]==judge[1][1] && judge[1][1]==judge[2][2]) {
			j[0]=judge[0][0];
			j[1]=j[0];
			j[2]=j[0];
		}
		else if(judge[0][2]==judge[1][1] && judge[1][1]==judge[2][0]) {
			j[0]=judge[0][2];
			j[1]=j[0];
			j[2]=j[0];
		}
		
		startbt.setDisable(false);
		if(j[0] == 7 && j[1] == 7 && j[2] == 7)
		{
			lbresult.setText("777点獲得！！！");
			point += 777;
		}
		else if(j[0] == 3 && j[1] == 3 && j[2] == 3)
		{
			count++;
			startbt.setDisable(false);
			stopbt[0].setDisable(false);
			stopbt[1].setDisable(false);
			stopbt[2].setDisable(false);
		}
		else if(j[0] >= 4 && j[0] == j[1] && j[1] == j[2])
		{
			lbresult.setText("100点獲得！！");
			point += 100;
		}
		else if(j[0] >= 4 && j[1] >= 4 && j[0] == j[1])
		{
			lbresult.setText("25点獲得！");
			point += 25;
		}
		else if(j[1] >= 4 && j[2] >= 4 && j[1] == j[2])
		{
			lbresult.setText("25点獲得！");
			point += 25;
		}
		else if(j[2] >= 4 && j[0] >= 4 && j[2] == j[0])
		{
			lbresult.setText("25点獲得！");
			point += 25;
		}
		else if(j[0] >= 4 && j[1] >= 4 && j[2] >= 4)
		{
			lbresult.setText("5点獲得");
			point += 5;
		}
		else if(j[0] == j[1] && j[1] == j[2])
		{
			lbresult.setText("50点獲得！");
			point += 50;
		}
		else if(j[0] == j[1] || j[1] == j[2] || j[2] == j[0])
		{
			lbresult.setText("10点獲得");
			point += 10;
		}
		if(count==0)
		{
			lblast.setText("合計"+point+"点獲得しました！");
			startbt.setDisable(true);
		}
	}
	
}
