package com.metattri.anp.TB1_CodingExamples.Live2;

//https://www.javatpoint.com/daemon-thread
class DaemonThread2 extends Thread{  
	 public void run(){  
	  System.out.println("Name: "+Thread.currentThread().getName());  
	  System.out.println("Daemon: "+Thread.currentThread().isDaemon());  
	 }  
	  
	 public static void main(String[] args){  
	  DaemonThread2 t1=new DaemonThread2();  
	  DaemonThread2 t2=new DaemonThread2();  
	  t1.start();  
	  t1.setDaemon(true);//will throw exception here  
	  t2.start();  
	 }  
	} 