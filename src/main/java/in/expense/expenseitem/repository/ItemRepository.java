package in.expense.expenseitem.repository;

import in.expense.expenseitem.model.ItemModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<ItemModel, String> {
    public void deleteAllByCategoryId(String categoryId);
    //public List<ItemModel> findAllByCategoryId(String categoryId);
}
