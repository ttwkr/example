import * as Crypto  from 'crypto-js'

class Block {
    public index:number
    public hash:string
    public previousHash:string
    public data:string
    public timestamp:number

    //hash 암호화
    static calculateHash = (
        index:string, 
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
console.log(blockChain)