package model;

import util.DataUtil;

import java.util.LinkedList;

import static util.DataUtil.clientDemandArr;

/**
 * Created by ab792 on 2017/1/18.
 * 卡车类，代表了一条路径
 */
public class Truck {
    private int id;
    //private double capacity;    //载重量
    /**************暂未使用****************/
    public static double capacity;
    private double nowCapacity; //当前载重量
    private LinkedList<Integer> customers = new LinkedList<Integer>();   //该路径的所有客户
    private int currentCus; ////当前客户
    private int cusNum; //客户数量
    private int firstCus;   //第一个客户
    private int lastCus;    //最后一个客户
    private double penalty;     //惩罚
    /**************暂未使用****************/
    private double height;  //高
    private double width;   //长
    private double length;  //宽
    private double maxDistance;     //限制的最长距离
    private double serviceTime;     //服务时间

    public Truck(int id) {
        this.id = id;
        nowCapacity = 0;
    }

    /**
     * 是否超载
     *
     * @return
     */
    public boolean isOverLoad() {
        return DataUtil.more(nowCapacity, capacity);
    }

    /**
     * 卡车是否出发
     *
     * @return
     */
    public boolean isEmpty() {
        return customers.isEmpty();
    }

    /**
     * 在当前路径中添加客户
     *
     * @param currentCus
     */
    public void addCus(int currentCus) {
        customers.add(currentCus);
        //更新当前载重量
        adddNowCapacity(clientDemandArr[currentCus]);
    }

    /**
     * 更新当前载重量
     *
     * @param demand
     * @return
     */
    public double adddNowCapacity(double demand) {
        return nowCapacity += demand;
    }

    /**
     * 判断是否能够加入新的客户
     *
     * @param nowCus
     * @return
     */
    public boolean checkNowCus(int nowCus) {
        return capacity > nowCapacity + clientDemandArr[nowCus];
    }

    /**
     * 计算一辆车的路径长度
     *
     * @return
     */
    private double calCost() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", nowCapacity=" + nowCapacity +
                ", customers=" + customers +
                ", cusNum=" + cusNum +
                '}';
    }

    /*********getters and setters**********/
    public int getId() {
        return id;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getNowCapacity() {
        return nowCapacity;
    }

    public int getCurrentCus() {
        return currentCus;
    }

    public void setCurrentCus(int currentCus) {
        this.currentCus = currentCus;
    }

    public LinkedList getCustomers() {
        return customers;
    }

    public int getCusNum() {
        return cusNum;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public double getServiceTime() {
        return serviceTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public void setCapacity(double capacity) {
        this.capacity = capacity;
    }*/

    public void setNowCapacity(double nowCapacity) {
        this.nowCapacity = nowCapacity;
    }

    public void setCustomers(LinkedList customers) {
        this.customers = customers;
    }

    public void setCusNum(int cusNum) {
        this.cusNum = cusNum;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setMaxDistance(double maxDistance) {
        this.maxDistance = maxDistance;
    }

    public void setServiceTime(double serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getFirstCus() {
        firstCus = customers.getFirst();
        return firstCus;
    }

    public int getLastCus() {
        lastCus = customers.getLast();
        return lastCus;
    }

    public void setFirstCus(int firstCus) {
        this.firstCus = firstCus;
    }

    public void setLastCus(int lastCus) {
        this.lastCus = lastCus;
    }
    /*********getters and setters**********/
}