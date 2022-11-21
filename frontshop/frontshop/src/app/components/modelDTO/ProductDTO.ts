export class ProductDTO {
    private productName!: String;
    private productPrice!: String;
    private productCategories!:  Array<String>;
    private productDescription!: String;
    private productImageUrl!: String;
    private productIconImageUrl!: String;

    constructor(productName: String, productPrice: String, productCategories: Array<String>,
         productDescription: String, productImageUrl: String, productIconImageUrl: String){
            this.productName = productName;
            this.productPrice = productPrice;
            this.productCategories = productCategories;
            this.productDescription = productDescription;
            this.productImageUrl = productImageUrl;
            this.productIconImageUrl = productIconImageUrl;
    }
}