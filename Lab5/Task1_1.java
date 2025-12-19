package Lab5;


interface FractionInterface {
    double getRealValue();  // получение вещественного значения дроби
    void setNumerator(int numerator);  // установка числителя
    void setDenominator(int denominator);  // установка знаменателя
}


public class Task1_1 implements FractionInterface {
    private int numerator;  // числитель
    private int denominator;  // знаменатель
    private Double cachedRealValue;  // кэшированное
    private boolean isCacheValid;  // флаг кэша


    public Task1_1(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.numerator = numerator;
        setDenominator(denominator);
        this.isCacheValid = false;
    }


    // получение вещественного значения дроби с кэшированием
    @Override
    public double getRealValue() {
        if (!isCacheValid || cachedRealValue == null) {
            cachedRealValue = (double) numerator / denominator;
            isCacheValid = true;
        }
        return cachedRealValue;
    }


    // установка числителя
    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        this.isCacheValid = false;  // сбрасываем кэш при изменении
    }


    // установка знаменателя с проверкой на 0 и обработкой отрицательных значений
    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        if (denominator < 0) {
            // если знаменатель отрицательный, переносим знак в числитель
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.denominator = denominator;
        }
        this.isCacheValid = false;  // сбрасываем кэш при изменении
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }


    // сравнение дробей по состоянию
    // две дроби считаются одинаковыми, когда у них одинаковые значения числителя и знаменателя
    @Override
    public boolean equals(Object obj) {
        // это один и тот же объект в памяти?
        if (this == obj) return true;
        // проверка на null и тип объектов
        if (obj == null || getClass() != obj.getClass()) return false;
        Task1_1 fraction = (Task1_1) obj;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }
}