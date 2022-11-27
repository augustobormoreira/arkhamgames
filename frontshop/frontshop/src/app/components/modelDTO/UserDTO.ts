export class UserDTO {
    username!: String;
    password!: String;
    token!: String;

    constructor(username: String, password: String){
        this.username = username;
        this.password = password;
        this.token = "eyciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
        
    }
}