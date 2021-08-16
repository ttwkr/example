import * as Crypto  from 'crypto-js'

class Block {
    public index:number
    public hash:string
    public previousHash:string
    public data:string
    public timestamp:number

    //hash 암호화
    // class 선언하지 않고 function 사용하려면 static 설정을 해야한다
    static calculateHash = (
        index:number, 
        previousHash:string, 
        data:string, 
        timestamp:number
        ):string => 
        Crypto.SHA256(index+previousHash+data+timestamp).toString()

    constructor(index: number, hash:string, previousHash:string, data:string, timestamp:number){
        this.index = index
        this.data = data
        this.hash = hash
        this.previousHash = previousHash
        this.timestamp = timestamp
    }
}

const genericBlock:Block = new Block(0, "20202020202", "", "hello", 123456)

let blockChain:Block[] = [genericBlock]

// 사용할 함수 설정
const getBlockchain = ():Block[] => blockChain
const getLastestBlock = ():Block => blockChain[blockChain.length - 1]
const getNewTimeStamp = ():number => Math.round(new Date().getTime() / 1000)

// Block 생성
const createBlock = (data:string): Block => {
    const previousBlock:Block = getLastestBlock()
    const newIndex:number = previousBlock.index + 1
    const newTimeStamp:number = getNewTimeStamp()
    const newHash:string = Block.calculateHash(newIndex, previousBlock.hash, data, newTimeStamp)

    const newBlock = new Block(newIndex, newHash, previousBlock.hash, data, newTimeStamp)

    return newBlock
}

console.log(createBlock("hi?"))