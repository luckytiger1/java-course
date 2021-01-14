package com.geekbrains.lesson11;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "buyers_products")
public class BuyerProduct {
    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "buyer_id")
        int buyerId;

        @Column(name = "product_id")
        int productId;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Id id = (Id) o;
            return buyerId == id.buyerId &&
                    productId == id.productId;
        }

        @Override
        public int hashCode() {
            return buyerId + productId;
        }
    }

    @EmbeddedId
    Id id;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

}
