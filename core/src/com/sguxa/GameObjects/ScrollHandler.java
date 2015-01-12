package com.sguxa.GameObjects;

/**
 * Created by r.gushin on 24.12.2014.
 */
public class ScrollHandler {
    // ScrollHandler создаст все необходимые нам объекты
    private Grass frontGrass,baskGrass;
    private Pipe pipe1,pipe2,pipe3;

    // ScrollHandler будет использовать следующие константы
    // чтобы определить, как быстро нам перемещать объекты
    // и какой промежуток между трубами

    // заглавные буквы используются по договоренности об именовании переменных
    public static final int SCROLL_SPEED=-59;
    public static final int PIPE_GAP=49;
    // конструктор получает значение по Y оси, где нам необходимо создать наши
    // Grass и Pipe объекты.
    public ScrollHandler(float yPos){
        frontGrass=new Grass(0,yPos,143,11,SCROLL_SPEED);
        baskGrass=new Grass(frontGrass.getTailX(),yPos,143,11,SCROLL_SPEED);

        pipe1=new Pipe(210,0,22,60,SCROLL_SPEED);
        pipe2=new Pipe(pipe1.getTailX()+PIPE_GAP,0,22,70,SCROLL_SPEED);
        pipe3=new Pipe(pipe2.getTailX()+PIPE_GAP,0,22,60,SCROLL_SPEED);

    }

    public void update(float delta){
        // обновляем все объекты
        frontGrass.update(delta);
        baskGrass.update(delta);
        pipe1.update(delta);
        pipe2.update(delta);
        pipe3.update(delta);

        // проверяем кто из объектов за левой границей
        // и соответственно сбрасываем параметры этого объекта
        if(pipe1.isScrolledLeft()){
            pipe1.reset(pipe3.getTailX()+PIPE_GAP);
        }else if(pipe2.isScrolledLeft()){
            pipe2.reset(pipe1.getTailX()+PIPE_GAP);
        }else if(pipe3.isScrolledLeft()){
            pipe3.reset(pipe2.getTailX()+PIPE_GAP);
        }
        // то-же самое с травой
        if(frontGrass.isScrolledLeft()){
            frontGrass.reset(baskGrass.getTailX());
        }else if(baskGrass.isScrolledLeft()){
            baskGrass.reset(frontGrass.getTailX());
        }
    }
    // методы доступа к переменным класса
    public Grass getFrontGrass(){
        return frontGrass;
    }

    public Grass getBaskGrass(){
        return baskGrass;
    }

    public Pipe getPipe1(){
        return pipe1;
    }

    public Pipe getPipe2(){
        return pipe2;
    }

    public Pipe getPipe3(){
        return pipe3;
    }

}
