class Curso {

    constructor(name, categoria, descricao) {
        
        this._id;

        this._name = name;
        this._categoria= categoria;
        this._descricao = descricao;
    }

    get id() {
        return this._id;
    }

    get name() {
        return this._name;
    }

    get categoria() {
        return this._categoria;
    }

    get descricao() {
        return this._descricao;
    }

    get numero() {
        return this._numero;
    }

    loadFromJSON(json) {

        for(let name in json) {

            switch(name) {
                case '_register':
                    this[name] = new Date(json[name]);
                break;
                default:
                    this[name] = json[name];
            }
        }
    }

     /**
      * Método responsável por pegar todos os itens no localStorage
      */

     static getLocalStorage() {
        
        //array de objetos local
        let users = []; //se não tiver ngm na session, inicia vazio

        //caso houver, faz o parse com o que já estão armazenados
        if(localStorage.getItem("cursos")) {
           
            users = JSON.parse(localStorage.getItem("cursos")); //cria o array

        }

        return users;
     }

     getNewId() {

        let usersID = parseInt(localStorage.getItem("usersID")); //ultimo id, será armazenado aqui

        //se ela nao existir, eu crio
        if(!usersID > 0) usersID = 0;

        usersID++;

        localStorage.setItem("usersID", usersID);

        return usersID;

     }

    save() {
        let users = Local.getLocalStorage();

        //chave unica para local
        if(this.id > 0) {

            //descobre qual o usuário que eu quero modificar
            users.map(u=> {

                if(u._id == this.id) { //se forem iguais, eu vou modificar
                   
                    //mesclar dois objetos json, copia atributos de um obj e gera um novo
                    Object.assign(u, this);

                }
                return u;
            });
        } else {
            //gerar novo id
            this._id = this.getNewId();

            users.push(this); //adiciona no final do array

        }
         //salvar no storage
         localStorage.setItem("cursos", JSON.stringify(users));
    }

    remove() {

        let users = Local.getLocalStorage();

        users.forEach((userData, index)=>{
            
            if(this._id == userData._id) { //encontra o id que eu vou remover
                
                users.splice(index, 1); //vc remove 1 elemento, a partir do índice

            }
        });

        localStorage.setItem("cursos", JSON.stringify(users));
    }



}