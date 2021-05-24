package FLOWERS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bouquet extends Flower implements Serializable {
    private List<Flower> flowers = new ArrayList<Flower>();
    private List<Аccessory> accessories = new ArrayList<Аccessory>();

    public Bouquet() {
        super("Букет", 0, "", 0, 0);
    }
    public Bouquet(String name) {
        super(name, 0, "", 0, 0);
    }

    public Bouquet addFlower(Flower flower) {
        flowers.add(flower);
        double price = this.getPrice();
        price += flower.getPrice();
        this.setPrice(price);
        return this;
    }
    public Bouquet addАccessory(Аccessory accessory) {
        accessories.add(accessory);
        double price = this.getPrice();
        price += accessory.getPrice();
        this.setPrice(price);
        return this;
    }
    public void sortFreshness(){
        this.flowers.sort(Comparator.comparing(Flower::getFreshInHours));
    }
    public Bouquet findLengthOfStems (double from, double to){
        Bouquet bouquetWithStems = new Bouquet();
        for (Flower flower1 :this.flowers){
            if (flower1.getLengthOfStems()>=from && flower1.getLengthOfStems()<=to)
                bouquetWithStems.addFlower(flower1);
        }
        return bouquetWithStems;
    }

    @Override
    public void Show(){
        if (this.flowers.isEmpty()) System.out.print("Букет пустой!");
        else {
            System.out.print("\n" + this.getName() +
                    "\nЦена букета: " + this.getPrice() + "\nКоличество цветов: "
                    + this.flowers.size() + "\nКоличество аксессуаров: "
                    + this.accessories.size() + "\nЦветы:\n");
            for (Flower flower1 : this.flowers) {
                flower1.Show();
            }
        }
        if (!this.accessories.isEmpty()) {
            System.out.print("\nАксессуары: \n");
            for (Аccessory accessory1 : this.accessories) {
                accessory1.Show();
            }
        }
    }
}

