export interface GeneVariant {
  id: string,
  gene: Gene,
  ntChange: string,
  proteinChange: string,
  otherMappings: string,
  alias: string,
  region: string,
  reportedClassification: string,
  lastEvaluated: Date,
  lastUpdated: Date,
  source: string,
  url: string
}

export interface Gene {
  id: string,
  name: string
}
