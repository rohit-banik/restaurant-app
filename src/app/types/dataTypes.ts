declare type category = {
  categoryId: string;
  categoryName: string;
  categoryDesc: string;
  categoryImage: string;
};
declare type dish = {
  dishId: string;
  dishName: string;
  dishDesc: string;
  dishPrice: number;
  categoryId: string;
  menuId: string;
  dishImage: string;
  dishNature: string;
};
export { category, dish };
