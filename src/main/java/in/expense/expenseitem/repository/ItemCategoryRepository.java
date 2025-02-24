package in.expense.expenseitem.repository;

import in.expense.expenseitem.model.ItemCategoryModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemCategoryRepository extends MongoRepository<ItemCategoryModel, String> {
}
