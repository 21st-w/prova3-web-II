const express = require('express');
const axios = require('axios');
const bodyParser = require('body-parser');
const session = require('express-session');

const app = express();

app.use(bodyParser.urlencoded({ extended: true }));
app.set('view engine', 'ejs');
app.use(express.static('public'));

app.use(session({
    secret: 'desafio07-clientes',
    resave: false,
    saveUninitialized: false
}));

const apiUrl = 'http://localhost:8080/api/clientes';


// Verifica se o usuário está autenticado
function verificarAutenticacao(req, res, next) {
    res.set('Cache-Control', 'no-cache, private, no-store, must-revalidate, max-stale=0, post-check=0, pre-check=0');
    
    if (req.session.autenticado) {
        return next();
    }

    res.redirect('/');
}


// Rota da tela de autenticação
app.get('/', (req, res) => {
    if (req.session.autenticado) {
        return res.redirect('/principal');
    }

    res.render('login', { mensagem: '' });
});


// Rota para autenticar
app.post('/autenticar', (req, res) => {
    const { usuario, senha } = req.body;

    if (!usuario && !senha) {
        return res.render('login', {
            mensagem: 'Informe o usuário e a senha.'
        });
    }

    if (!usuario) {
        return res.render('login', {
            mensagem: 'Informe o usuário.'
        });
    }

    if (!senha) {
        return res.render('login', {
            mensagem: 'Informe a senha.'
        });
    }

    if (usuario === 'admin' && senha === 'admin') {
        req.session.autenticado = true;

        return res.redirect('/principal');
    }

    res.render('login', {
        mensagem: 'Usuário e/ou senha incorreto.'
    });
});


// Rota para sair
app.get('/sair', (req, res) => {
    req.session.destroy(() => {
        res.clearCookie('connect.sid');
        res.redirect('/');
    });
});


// Rota para listar, pesquisar e paginar os clientes
app.get('/principal', verificarAutenticacao, async (req, res) => {
    const nome = req.query.nome || '';

    let pagina = parseInt(req.query.pagina);

    if (isNaN(pagina) || pagina < 1) {
        pagina = 1;
    }

    try {
        const response = await axios.get(`${apiUrl}/pagina`, {
            params: {
                nome: nome,
                page: pagina - 1
            }
        });

        const dados = response.data;

        res.render('index', {
            clientes: dados.content,
            nome: nome,
            paginaAtual: dados.number + 1,
            totalPaginas: dados.totalPages,
            totalRegistros: dados.totalElements
        });

    } catch (error) {
        console.error(error);

        res.status(500).send('Erro ao buscar clientes');
    }
});


// Rota para exibir o formulário de cadastro
app.get('/novo', verificarAutenticacao, (req, res) => {
    res.render('cadastro');
});


// Rota para cadastrar um novo cliente
app.post('/novo', verificarAutenticacao, async (req, res) => {
    const {
        nome,
        nascimento,
        cpf,
        endereco,
        telefone,
        email
    } = req.body;

    try {
        await axios.post(apiUrl, {
            nome,
            nascimento,
            cpf,
            endereco,
            telefone,
            email
        });

        res.redirect('/principal');

    } catch (error) {
        console.error(error);

        res.status(500).send('Erro ao cadastrar cliente');
    }
});


// Rota para exibir formulário de edição
app.get('/editar/:id', verificarAutenticacao, async (req, res) => {
    const { id } = req.params;

    try {
        const response = await axios.get(`${apiUrl}/${id}`);

        const cliente = response.data;

        res.render('editar', { cliente });

    } catch (error) {
        console.error(error);

        res.status(500).send('Erro ao buscar cliente');
    }
});


// Rota para atualizar um cliente
app.post('/editar/:id', verificarAutenticacao, async (req, res) => {
    const { id } = req.params;

    const {
        nome,
        nascimento,
        cpf,
        endereco,
        telefone,
        email
    } = req.body;

    try {
        await axios.put(`${apiUrl}/${id}`, {
            nome,
            nascimento,
            cpf,
            endereco,
            telefone,
            email
        });

        res.redirect('/principal');

    } catch (error) {
        console.error(error);

        res.status(500).send('Erro ao atualizar cliente');
    }
});


// Rota para excluir um cliente
app.post('/excluir/:id', verificarAutenticacao, async (req, res) => {
    const { id } = req.params;

    try {
        await axios.delete(`${apiUrl}/${id}`);

        res.redirect('/principal');

    } catch (error) {
        console.error(error);

        res.status(500).send('Erro ao excluir cliente');
    }
});


app.listen(3000, () => {
    console.log('Servidor rodando na porta 3000');
});
