import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core'; 
import { faSquarePlus } from '@fortawesome/free-regular-svg-icons';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { environment } from 'src/environments/environment';
import { ProductDTO } from '../modelDTO/ProductDTO';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {
  @ViewChild('content') content: any;
  private closeResult!: String;

  gameName = "Nome do Jogo";
  imageUrl = "https://ih1.redbubble.net/image.1714552193.4179/flat,750x,075,f-pad,750x1000,f8f8f8.jpg";

  faSquarePlus = faSquarePlus;
  constructor(private modalService: NgbModal,private httpClient: HttpClient) { }

  ngOnInit(): void {
  }

  onSubmit(product: any){
    const newProduct: ProductDTO = this.createNewProductDTO(product);
    this.httpClient.post(`${environment.API_URL}/products/addProduct`, newProduct).
    subscribe((result) => {
      console.log("result", result); 
    });
  }
  
  createNewProductDTO(product: any): ProductDTO{
    return new ProductDTO(product.target.productName.value,
      product.target.productPrice.value,
      this.turnStringIntoArrayOfStrings(product.target.productCategories.value),
      product.target.productDescription.value,
      product.target.productImageUrl.value,
      product.target.productIconUrl.value);
  } 

  turnStringIntoArrayOfStrings(nonArrayString: String): Array<String>{
    return nonArrayString.split(",");
  }

  atualizaUrl(content: HTMLInputElement){
    this.imageUrl = content.value;
  }

  openModalService() {
    this.modalService.open(this.content, {size: 'xl'} ).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      console.log(reason);
    })
  }
  }


