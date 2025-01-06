package eCommerce.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "board")
public class Board {

   @Id
   @GeneratedValue
   
   int boardId;
   
   String title;
   String customerName;
   LocalDate date;
   String content;

   @Version
   private int version; // 버전 필드

   public int getBoardId() {
      return boardId;
   }

   public void setBoardId(int boardId) {
      this.boardId = boardId;
   }

   public String getCustomerName() {
      return customerName;
   }

   public void setCustomerName(String customerName) {
      this.customerName = customerName;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public LocalDate getDate() {
      return date;
   }

    @PrePersist
    public void prePersist() {
        this.date = LocalDate.now();
    }

	

}