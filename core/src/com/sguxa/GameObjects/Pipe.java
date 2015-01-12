package com.sguxa.GameObjects;

import java.util.Random;

/**
 * Created by r.gushin on 23.12.2014.
 */
public class Pipe extends Scrollable{

    private Random r;

    // Когда констуктор Pipe вызван – вызовите конструтор родителя (Scrollable)
    public Pipe(float x, float y, int width, int height, float scrollSpeed) {
        super(x, y, width, height, scrollSpeed);
        // Иницилизируйте объект типа Random для генерации случайных чисел
        r=new Random();
    }

    @Override
    public void reset(float newX){
        // вызовите reset метод в родительском классе (Scrollable)
        super.reset(newX);
        // Измените высоту на случайное значение
        height=r.nextInt(90)+15;
    }
}
